package com.dtcc.workflowmetrics.util.simulator.workflows;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkflowGeneratorTests {

    @Test
    public void generateTestWorkflow() {
        int maxIssues = 5;
        int currentIssue = 0;
        while (++currentIssue <= maxIssues) {
            IssueHistory issue = new IssueHistory();
            issue.setSummary("MyIssue");
            issue.setIssueType("Task");
            issue.setDescription("My Description");
            issue.setKey("Test-" + currentIssue);
            for (IssueHistory generatedIssue : WorkflowGenerator.generateWorkflow(issue)) {
                System.out.println(generatedIssue.toJiraJSONFormat());
            }
        }

    }
}
