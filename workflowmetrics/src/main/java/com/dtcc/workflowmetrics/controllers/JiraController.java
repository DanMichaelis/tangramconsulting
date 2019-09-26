package com.dtcc.workflowmetrics.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dtcc.workflowmetrics.issueObjects.util.IssueConverter;
import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistory;
import com.dtcc.workflowmetrics.metricsitems.jira.IssueList;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;
import com.dtcc.workflowmetrics.util.simulator.workflows.WorkflowGenerator;

import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*")
@RestController
public class JiraController {

    private int counter = 0;

    @RequestMapping("/jira/addIssue")
    public void jiraMessage(@RequestHeader MultiValueMap<String, String> headers, @RequestBody String inboundBody) {
        System.out.println("Service Invocation " + counter++);
        System.out.println("Data:  " + inboundBody);
        WebhookData issue = IssueConverter.webhookJSONToWebhookData(inboundBody);
        //IssueList.addIssue(issue);
    }

    @RequestMapping("/jira/getIssueByKey")
    public ArrayList<IssueHistory> getIssueByKey(@RequestParam(value = "key") String key) {
        System.out.println("key:  " + key);
        return IssueList.getIssuesByKey(key);
    }
    
    @RequestMapping("/jira/getJiraJsonByKey")
    public String getJiraJsonByKey(@RequestParam(value = "key") String key) {
       return IssueList.getIssuesByKey(key).get(0).toJiraJSONFormat();
    }
    
    @RequestMapping("/jira/generateTestData")
    public String generateTestData(@RequestParam(value = "issueCount", defaultValue = "5") String issueCount) {
        int maxIssues = Integer.valueOf(issueCount).intValue();
        int currentIssue = 0;
        while (++currentIssue <= maxIssues) {
            IssueHistory issue = new IssueHistory();
            issue.setSummary("MyIssue");
            issue.setIssueType("Task");
            issue.setDescription("My Description");
            issue.setKey("Test-" + currentIssue);
            for (IssueHistory generatedIssue : WorkflowGenerator.generateWorkflow(issue)) {
                System.out.println(generatedIssue.toJiraJSONFormat());
                IssueConverter.toFile(generatedIssue);
            }
        }
        return "Done";
    }
    
    @RequestMapping("/jira/parsePulledIssueData")
    public String parsePulledIssueData(@RequestParam(value = "loadDirectory", defaultValue = "ASPE") String loadDirectory) {
        System.out.println("Inside parsePulledIssueData");
        IssueConverter.convertJsonFilesInDirectory("/Users/dan.michaelis/CodeProjects/tangramconsulting/workflowmetrics/src/main/resources/" + loadDirectory);
        return "{\"status\":\"Complete\"}";
    }
}
