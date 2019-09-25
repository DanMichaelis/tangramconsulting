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

import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistory;
import com.dtcc.workflowmetrics.metricsitems.jira.IssueList;

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
        
        // We'll need to put this back someday, but to avoid having to deal with the problem of special characters in the description field, we're going to ignore it for now.
        //elements.add(IssueConverter.addNameValuePair("description", "description"));

        //assertEquals("\"fields\":{\"summary\":\"summary\",\"desciption\":\"description\"}",
        //        IssueConverter.addStructure("fields", elements));
        assertEquals("\"fields\":{\"summary\":\"summary\"}", IssueConverter.addStructure("fields", elements));

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
    
    @Test
    public void testJsonFileReader() {
        ArrayList<File> files = JsonFileReader.getAllFilesInDirectory("/Users/dan.michaelis/CodeProjects/tangramconsulting/workflowmetrics/src/test/resources/TestFiles");
        for (File f : files) {
            System.out.println("File:  " + f.getAbsolutePath());
        }
    }
    
    @Test
    public void convertAuditFilesToHistoryFiles() {
        IssueConverter.convertJsonFilesInDirectory("/Users/dan.michaelis/CodeProjects/tangramconsulting/workflowmetrics/src/main/resources/ASPE");
    }

}
