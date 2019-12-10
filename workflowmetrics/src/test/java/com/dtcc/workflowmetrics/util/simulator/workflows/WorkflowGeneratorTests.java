package com.dtcc.workflowmetrics.util.simulator.workflows;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtcc.workflowmetrics.dao.EventUserCustomFieldDao;
import com.dtcc.workflowmetrics.dao.EventUserDao;
import com.dtcc.workflowmetrics.entity.EventUser;
import com.dtcc.workflowmetrics.entity.EventUserCustomField;
import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkflowGeneratorTests {

	@Autowired
	EventUserDao eventUserDao;

	@Autowired
	EventUserCustomFieldDao eventUserCustomFieldDao;
	
	
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
    
    @Test
    public void generateTestEventUserEntity() {
    	
			
    	EventUser eventUser = new EventUser();
    	
    	eventUser.setUserID(1011);
    	eventUser.setEmailId("jiniya.ghosh@perficient.com");
    	eventUser.setUserName("Jiniya");
    	eventUser.setSourceSystem(12);
    	Date dt = new Date();
    	eventUser.setLastUpdateDate(dt.getTime());
    	
    	EventUser storedEventUser = eventUserDao.save(eventUser);
    	
    	assertEquals(storedEventUser.getUserID(), eventUser.getUserID());
    }

    @Test
    public void generateTestEventUserCustomFieldEntity() {
    	
			
    	EventUserCustomField eventUserCustFld = new EventUserCustomField();
    	
    	eventUserCustFld.setUserID(1011);
    	eventUserCustFld.setSourceSystem(1);
    	eventUserCustFld.setFieldName("ABC");
    	eventUserCustFld.setFieldDatatype("String");
       	eventUserCustFld.setFieldValue("ABCValue");
        Date dt = new Date();
    	eventUserCustFld.setCreateDate(dt.getTime());
    	
    	EventUserCustomField storedEventUserCustFld = eventUserCustomFieldDao.save(eventUserCustFld);
    	
    	assertEquals(storedEventUserCustFld.getUserID(), eventUserCustFld.getUserID());
    }

}
