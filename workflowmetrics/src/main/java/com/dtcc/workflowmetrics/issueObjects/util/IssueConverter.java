package com.dtcc.workflowmetrics.issueObjects.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.core.env.Environment;

import com.dtcc.workflowmetrics.issueObjects.IssueHistory;
import com.dtcc.workflowmetrics.issueObjects.IssueHistoryId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IssueConverter {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static final String toJson(IssueHistory issue) {
        StringBuffer sb = new StringBuffer();

        ArrayList<String> transitionElements = new ArrayList<String>();
        transitionElements.add(addNameValuePair("from_status", issue.getPreviousStatus()));
        transitionElements.add(addNameValuePair("to_status", issue.getStatus()));
        transitionElements.add(addNameValuePair("previous_status_duration", issue.getDurationInPreviousStatus()));

        ArrayList<String> fields = new ArrayList<String>();
        fields.add(addNameValuePair("key", issue.getKey()));
        fields.add(addNameValuePair("summary", issue.getSummary()));
        fields.add(addNameValuePair("description", issue.getDescription()));

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

    public static final String fromAuditToHistory(String auditJSONString) {
        JsonNode auditNode = null;

        try {
            auditNode = mapper.readTree(auditJSONString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        ArrayList<String> transitionElements = new ArrayList<String>();
        transitionElements.add(addNameValuePair("from_status", issue.getPreviousStatus()));
        transitionElements.add(addNameValuePair("to_status", issue.getStatus()));
        transitionElements.add(addNameValuePair("previous_status_duration", issue.getDurationInPreviousStatus()));

        ArrayList<String> fields = new ArrayList<String>();
        fields.add(addNameValuePair("key", issue.getKey()));
        fields.add(addNameValuePair("summary", issue.getSummary()));
        fields.add(addNameValuePair("description", issue.getDescription()));

        sb.append(addStructure("transition", transitionElements));
        sb.append(",");

        sb.append(addStructure("issue", addStructure("fields", fields)));
        sb.append(",");

        sb.append(addNameValuePair("timestamp", issue.getEventDate().getTime()));

        return encloseItem(sb.toString());
        

        return null;
    }
}
