package com.dtcc.workflowmetrics.issueObjects.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.core.env.Environment;

import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistory;
import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistoryId;
import com.dtcc.workflowmetrics.metricsitems.jira.issue.Issue;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class IssueConverter {

    private static final ObjectMapper mapper = (new ObjectMapper()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    

    
    public static final Issue toJiraIssue(String issueJson) {
        try {
            Issue issue = mapper.readValue(issueJson, Issue.class);
            return issue;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static final String toJson(IssueHistory issue) {
        StringBuffer sb = new StringBuffer();

        ArrayList<String> transitionElements = new ArrayList<String>();
        transitionElements.add(addNameValuePair("from_status", issue.getPreviousStatus()));
        transitionElements.add(addNameValuePair("to_status", issue.getStatus()));
        transitionElements.add(addNameValuePair("previous_status_duration", issue.getDurationInPreviousStatus()));

        ArrayList<String> fields = new ArrayList<String>();
        fields.add(addNameValuePair("key", issue.getKey()));
        fields.add(addNameValuePair("summary", issue.getSummary()));
        fields.add(addNameValuePair("sysId", issue.getSysId()));
        //fields.add(addNameValuePair("description", issue.getDescription())); 
        fields.add(addStructure("issuetype", addNameValuePair("name", issue.getIssueType())));

        sb.append(addStructure("transition", transitionElements));
        sb.append(",");

        sb.append(addStructure("issue", addStructure("fields", fields)));
        sb.append(",");

        sb.append(addNameValuePair("timestamp", issue.getEventDate().getTime()));

        return encloseItem(sb.toString());
    }

    protected static final String addNameValuePair(String name, String value) {
        return "\"" + name + "\":\"" + value + "\"";
    }

    protected static final String addNameValuePair(String name, long value) {
        return "\"" + name + "\":" + value + "";
    }

    protected static final String addStructure(String structureName, ArrayList<String> elements) {
        StringBuffer sb = new StringBuffer();
        for (String element : elements) {
            sb.append(element + ",");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        sb.insert(0, "\"" + structureName + "\":{");
        sb.append("}");
        return sb.toString();
    }

    protected static final String addStructure(String structureName, String fields) {
        StringBuffer sb = new StringBuffer("\"" + structureName + "\":{");
        sb.append(fields);
        sb.append("}");
        return sb.toString();

    }

    protected static final String encloseItem(String item) {
        return "{" + item + "}";
    }

    public static final void toFile(IssueHistory issue) {

        String filePath = "/Users/dan.michaelis/jira_output_files";
        SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD_HH-mm-ss");
        String fileName = issue.getKey() + "-" + sdf.format(issue.getEventDate()) + ".json";

        try {
            Files.write(Paths.get(filePath + File.separator + fileName), toJson(issue).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static final ArrayList<IssueHistory> fromAuditToHistory(String auditJSONString) {

        // Create the return array to hold issues
        ArrayList<IssueHistory> issues = new ArrayList<IssueHistory>();

        // Create the nodes and other objects that we'll work with, so that we don't do
        // that in loops.
        JsonNode auditNode = null;
        JsonNode historyNodes = null;
        JsonNode items = null;
        IssueHistory issue = null;
        IssueHistory newIssue = null;
        Date lastStatusDate = null;

        try {
            auditNode = mapper.readTree(auditJSONString);

            // Create the history record that indicates that the item was created; that's
            // not represented the same way as it is in the webhook call

            issue = new IssueHistory();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");

            try {
                issue.setDescription(auditNode.at("/fields/description").asText())
                        .setEventDate(sdf.parse(auditNode.at("/fields/created").asText()))
                        .setDurationInPreviousStatus(issue.getEventDate())
                        .setIssueType(auditNode.at("/fields/issuetype/name").asText())
                        .setKey(auditNode.at("/key").asText()).setPreviousStatus(null).setStatus("To Do")
                        .setSummary(auditNode.at("/fields/summary").asText()).setSysId(auditNode.at("/fields/customfield_18506").asText());
               
                issues.add(issue);
                
                lastStatusDate = issue.getEventDate();
            } catch (ParseException e) {
                throw new RuntimeException("Couldn't parse issue " + auditJSONString, e);
            }

            historyNodes = auditNode.get("changelog").get("histories");

            if (historyNodes.isArray()) {
                for (JsonNode historyNode : historyNodes) {
                    items = historyNode.get("items");
                    for (JsonNode itemNode : items) {
                        if (itemNode.at("/field").asText().toLowerCase().contentEquals("status")) {
                            newIssue = cloneIssue(issue);
                            newIssue.setStatus(itemNode.at("/toString").asText());
                            newIssue.setPreviousStatus(itemNode.at("/fromString").asText());
                            try {
                                newIssue.setEventDate(sdf.parse(historyNode.at("/created").asText()));
                            } catch (ParseException e) {
                                throw new RuntimeException("Couldn't parse change log " + itemNode.toString(), e);
                            }
                            newIssue.setDurationInPreviousStatus(lastStatusDate);
                            issues.add(newIssue);
                            lastStatusDate = newIssue.getEventDate();
                        }
                    }
                }
            } else {
                throw new RuntimeException("No arraynode at /changelog/histories");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return issues;
    }

    public static IssueHistory cloneIssue(IssueHistory originalIssue) {
        IssueHistory clone = new IssueHistory();
        clone.setDescription(originalIssue.getDescription()).setEventDate(originalIssue.getEventDate())
                .setIssueType(originalIssue.getIssueType()).setKey(originalIssue.getKey())
                .setPreviousStatus(originalIssue.getPreviousStatus()).setStatus(originalIssue.getStatus())
                .setSummary(originalIssue.getSummary()).setDurationInPreviousStatus(originalIssue);
        return clone;
    }
    
    public static void convertJsonFilesInDirectory(String directory) {
        ArrayList<File> files = JsonFileReader.getAllFilesInDirectory(directory);
        for (File f : files) {
            try {
                byte[] fileBytes = Files.readAllBytes(f.toPath());
                Issue issue = IssueConverter.toJiraIssue(new String(fileBytes));
                System.out.println(issue.toString());
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /*
     * public static void convertJsonFilesInDirectory(String directory) {
     * 
     * ArrayList<File> files = JsonFileReader.getAllFilesInDirectory(directory);
     * ArrayList<IssueHistory> issues = null;
     * 
     * for (File f : files) { StringBuilder contentBuilder = new StringBuilder();
     * try (Stream<String> stream = Files.lines( Paths.get(f.getAbsolutePath()),
     * StandardCharsets.UTF_8)) { stream.forEach(s ->
     * contentBuilder.append(s).append("\n")); issues =
     * fromAuditToHistory(contentBuilder.toString());
     * issues.stream().forEach(i->toFile(i)); } catch (IOException e) { throw new
     * RuntimeException("Couldn't stream file " + f.getAbsolutePath(), e); }
     * 
     * 
     * } }
     */
    
    public static WebhookData webhookJSONToWebhookData(String webhookJSON) {
        WebhookData data = null;
        try {
        	
            data = mapper.readValue(webhookJSON, WebhookData.class);
            
         } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't parse JSON string from webhook:  " + webhookJSON, e);
        }
        try {
            System.out.println("Converted Data:  " + mapper.writeValueAsString(data));    
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        return data;
    }
}
