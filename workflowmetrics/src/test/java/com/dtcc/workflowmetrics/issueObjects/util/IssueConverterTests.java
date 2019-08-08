package com.dtcc.workflowmetrics.issueObjects.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import org.assertj.core.util.Files;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtcc.workflowmetrics.issueObjects.IssueHistory;
import com.dtcc.workflowmetrics.issueObjects.IssueList;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/TestProperties/fileLocation.properties")
public class IssueConverterTests {

    private Environment env;

    @Test
    public void testStructureCreatorWithArray() {
        ArrayList<String> elements = new ArrayList<String>();
        elements.add(IssueConverter.addNameValuePair("summary", "summary"));
        elements.add(IssueConverter.addNameValuePair("desciption", "description"));
        // System.out.println(IssueToJsonConverter.addStructure("fields", elements));
        assertEquals("\"fields\":{\"summary\":\"summary\",\"desciption\":\"description\"}",
                IssueConverter.addStructure("fields", elements));
    }

    @Test
    public void testStructureCreatorWithString() {
        ArrayList<String> elements = new ArrayList<String>();
        elements.add(IssueConverter.addNameValuePair("summary", "summary"));
        elements.add(IssueConverter.addNameValuePair("desciption", "description"));
        // System.out.println(IssueToJsonConverter.addStructure("fields", elements));
        assertEquals("\"fields\":{\"summary\":\"summary\",\"desciption\":\"description\"}",
                IssueConverter.addStructure("fields", elements));

        System.out.println(IssueConverter.addStructure("issue", IssueConverter.addStructure("fields", elements)));
    }

    @Test
    public void testIssueToJson() {
        IssueHistory i = new IssueHistory();
        i.setStatus("In Progress").setDescription("MyDescription").setIssueType("Task").setKey("CM-1")
                .setPreviousStatus("To Do").setEventDate(new Date(System.currentTimeMillis())).setSummary("MySummary");
        System.out.println(IssueConverter.toJson(i));
    }

    @Test
    public void testFromAuditHistory() {

        try {
            //File testAuditHistory = new ClassPathResource("TestFiles/issueWithHistory.json").getFile();
            File testAuditHistory = new ClassPathResource("TestFiles/CDAAS-7.json").getFile();
            ArrayList<IssueHistory> issues = IssueConverter.fromAuditToHistory(Files.contentOf(testAuditHistory, Charset.defaultCharset()));
            for (IssueHistory issue : issues) {
                IssueList.addIssue(issue);
            }
            
            testAuditHistory = new ClassPathResource("TestFiles/CDAAS-268.json").getFile();
            issues = IssueConverter.fromAuditToHistory(Files.contentOf(testAuditHistory, Charset.defaultCharset()));
            for (IssueHistory issue : issues) {
                IssueList.addIssue(issue);
            }
            
            testAuditHistory = new ClassPathResource("TestFiles/CDAAS-269.json").getFile();
            issues = IssueConverter.fromAuditToHistory(Files.contentOf(testAuditHistory, Charset.defaultCharset()));
            for (IssueHistory issue : issues) {
                IssueList.addIssue(issue);
            }
            
            for (IssueHistory issue : IssueList.getAllIssues()) {
                System.out.println(issue.toString(true));
                IssueConverter.toFile(issue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
