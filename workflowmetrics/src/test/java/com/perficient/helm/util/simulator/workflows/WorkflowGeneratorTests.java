package com.perficient.helm.util.simulator.workflows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.helm.dao.EventUserCustomFieldDao;
import com.perficient.helm.dao.EventUserDao;
import com.perficient.helm.events.jira.IssueHistory;
import com.perficient.helm.util.simulator.workflows.WorkflowGenerator;

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
    
	/*
	 * @Test public void generateTestEventUserEntity() {
	 * 
	 * 
	 * EventUser eventUser = new EventUser();
	 * 
	 * eventUser.setId("jiniya.ghosh@perficient.com");
	 * eventUser.setEmailId("jiniya.ghosh@perficient.com");
	 * eventUser.setUserName("Jiniya"); eventUser.setSourceSystem(12); Date dt = new
	 * Date(); eventUser.setLastUpdateDate(dt.getTime());
	 * 
	 * EventUser storedEventUser = eventUserDao.save(eventUser);
	 * 
	 * assertEquals(storedEventUser.getId(), eventUser.getId()); }
	 * 
	 * @Test public void generateTestEventUserCustomFieldEntity() {
	 * 
	 * 
	 * EventUserCustomField eventUserCustFld = new EventUserCustomField();
	 * 
	 * eventUserCustFld.setUserID("jiniya.ghosh@perficient.com");
	 * eventUserCustFld.setSourceSystem(1); eventUserCustFld.setFieldName("ABC");
	 * eventUserCustFld.setFieldDatatype("String");
	 * eventUserCustFld.setFieldValue("ABCValue"); Date dt = new Date();
	 * eventUserCustFld.setCreateDate(dt.getTime());
	 * 
	 * EventUserCustomField storedEventUserCustFld =
	 * eventUserCustomFieldDao.save(eventUserCustFld);
	 * 
	 * assertEquals(storedEventUserCustFld.getUserID(),
	 * eventUserCustFld.getUserID());
	 * 
	 * eventUserCustFld = new EventUserCustomField();
	 * 
	 * eventUserCustFld.setUserID("jiniya.ghosh@perficient.com");
	 * eventUserCustFld.setSourceSystem(1); eventUserCustFld.setFieldName("ABC");
	 * eventUserCustFld.setFieldDatatype("String");
	 * eventUserCustFld.setFieldValue("BCDValue"); dt = new Date();
	 * eventUserCustFld.setCreateDate(dt.getTime());
	 * 
	 * storedEventUserCustFld = eventUserCustomFieldDao.save(eventUserCustFld);
	 * 
	 * assertEquals(storedEventUserCustFld.getUserID(),
	 * eventUserCustFld.getUserID()); }
	 */
}
