package com.perficient.helm.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.helm.dataaccess.rest.IssueRESTDAO;
import com.perficient.helm.entity.MetricsItems;
import com.perficient.helm.events.jira.IssueHistory;
import com.perficient.helm.events.jira.IssueList;
import com.perficient.helm.events.jira.webhook.WebhookData;
import com.perficient.helm.issueObjects.util.IssueConverter;
import com.perficient.helm.service.MetricsItemsDaoService;
import com.perficient.helm.service.UserHarmonizerService;
import com.perficient.helm.util.simulator.workflows.WorkflowGenerator;

@CrossOrigin(origins = "*")
@RestController
public class JiraController {

    private int counter = 0;

    @Autowired
	//private JiraService jiraService;
    private UserHarmonizerService userHarmonizerService;
    
    @Autowired
    private MetricsItemsDaoService metricsItemsDaoService;

    @RequestMapping("/jira/addIssue")
    public void jiraMessage(@RequestHeader MultiValueMap<String, String> headers, @RequestBody String inboundBody) {
        System.out.println("Service Invocation " + counter++);
        
        
        WebhookData issue = IssueConverter.webhookJSONToWebhookData(inboundBody);

        MetricsItems metricsItems = userHarmonizerService.harmonizeJira(issue);
        
        MetricsItems savedItem = metricsItemsDaoService.save(metricsItems);
        
        System.out.println(issue);
        
        System.out.println("Data:  " + inboundBody);
    }

    @RequestMapping("/jira/getIssueByKey")
    public ArrayList<IssueHistory> getIssueByKey(@RequestParam(value = "key") String key) {
       IssueRESTDAO.getIssue(key);
       return null;
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
