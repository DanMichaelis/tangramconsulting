package com.dtcc.workflowmetrics.issueObjects.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtcc.workflowmetrics.issueObjects.IssueHistory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueConverterTests {
    
    

	@Test
	public void testStructureCreatorWithArray() {
	    ArrayList<String> elements = new ArrayList<String>();
	    elements.add(IssueConverter.addNameValuePair("summary", "summary"));
	    elements.add(IssueConverter.addNameValuePair("desciption", "description"));
	    //System.out.println(IssueToJsonConverter.addStructure("fields", elements));
	    assertEquals("\"fields\":{\"summary\":\"summary\",\"desciption\":\"description\"}", IssueConverter.addStructure("fields", elements));
	}
	
	@Test
	public void testStructureCreatorWithString() {
	    ArrayList<String> elements = new ArrayList<String>();
        elements.add(IssueConverter.addNameValuePair("summary", "summary"));
        elements.add(IssueConverter.addNameValuePair("desciption", "description"));
        //System.out.println(IssueToJsonConverter.addStructure("fields", elements));
        assertEquals("\"fields\":{\"summary\":\"summary\",\"desciption\":\"description\"}", IssueConverter.addStructure("fields", elements));
        
        System.out.println(IssueConverter.addStructure("issue", IssueConverter.addStructure("fields", elements)));
	}
	
	@Test
	public void testIssueToJson() {
	    IssueHistory i = new IssueHistory();
	    i.setStatus("In Progress").setDescription("MyDescription").setIssueType("Task").setKey("CM-1").setPreviousStatus("To Do").setEventDate(new Date(System.currentTimeMillis())).setSummary("MySummary");
	    System.out.println(IssueConverter.toJson(i));
	}

}
