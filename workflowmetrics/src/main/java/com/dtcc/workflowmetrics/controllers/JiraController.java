package com.dtcc.workflowmetrics.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dtcc.workflowmetrics.dataaccess.rest.IssueRESTDAO;
import com.dtcc.workflowmetrics.entity.MetricsItems;
import com.dtcc.workflowmetrics.issueObjects.util.IssueConverter;
import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistory;
import com.dtcc.workflowmetrics.metricsitems.jira.IssueList;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;
import com.dtcc.workflowmetrics.service.MetricsItemsDaoService;
import com.dtcc.workflowmetrics.service.UserHarmonizerService;
import com.dtcc.workflowmetrics.util.simulator.workflows.WorkflowGenerator;

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
        System.out.println("Data:  " + inboundBody);
        
        WebhookData issue = IssueConverter.webhookJSONToWebhookData(inboundBody);

        MetricsItems metricsItems = userHarmonizerService.harmonizeJira(issue);
        
        MetricsItems savedItem = metricsItemsDaoService.save(metricsItems);
        
        System.out.println(issue);
        
        //IssueList.addIssue(issue);
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
