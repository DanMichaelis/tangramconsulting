package com.dtcc.workflowmetrics.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtcc.workflowmetrics.dao.CommentDao;
import com.dtcc.workflowmetrics.dao.FieldsDao;
import com.dtcc.workflowmetrics.dao.IssueDao;
import com.dtcc.workflowmetrics.dao.IssueLinkDao;
import com.dtcc.workflowmetrics.dao.IssueTypeDao;
import com.dtcc.workflowmetrics.dao.ProjectDao;
import com.dtcc.workflowmetrics.dao.TStatusDurationDao;
import com.dtcc.workflowmetrics.dao.TransitionDao;
import com.dtcc.workflowmetrics.dao.TransitionDurationDao;
import com.dtcc.workflowmetrics.dao.UserDao;
import com.dtcc.workflowmetrics.metricsitems.jira.common.Issuetype;
import com.dtcc.workflowmetrics.metricsitems.jira.common.Project;
import com.dtcc.workflowmetrics.metricsitems.jira.common.User;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookIssue;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookTransition;
import com.dtcc.workflowmetrics.pojo.Comment;
import com.dtcc.workflowmetrics.pojo.Issue;
import com.dtcc.workflowmetrics.pojo.IssueType;
import com.dtcc.workflowmetrics.pojo.ProjectDetails;
import com.dtcc.workflowmetrics.pojo.Transition;
import com.dtcc.workflowmetrics.pojo.UserDetail;

@Service
public class JiraServiceImpl implements JiraService {

	@Autowired
	CommentDao commentDao;
	
	@Autowired
	FieldsDao fieldsDao;
	
	@Autowired
	IssueDao issueDao;
	
	@Autowired
	IssueLinkDao issueLinkDao;
	
	@Autowired
	IssueTypeDao issueTypeDao;
	
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	TransitionDao transitionDao;
	
	@Autowired
	TransitionDurationDao transitionDurationDao;
	
	@Autowired
	TStatusDurationDao tStatusDurationDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void addJiraData(WebhookData data) {
		
		UserDetail userdetail = new UserDetail();
		ProjectDetails projectDetails = new ProjectDetails();
		IssueType issueType = new IssueType();
		Issue issueDetail = new Issue();
		Comment comment = new Comment();
		Transition transition = new Transition();
		
		WebhookTransition webhookTransition = data.getTransition();
		User user = data.getUser();
		Project project = data.getIssue().getFields().getProject();
		Issuetype issuetype = data.getIssue().getFields().getIssuetype();
		WebhookIssue webhookIssue = data.getIssue();
		
		userdetail.setSelf(user.getSelf());
		userdetail.setName(user.getName());
		userdetail.setKey(user.getKey());
		userdetail.setEmailId(user.getEmailAddress());
		
		userDao.addUser(userdetail);
		
		projectDetails.setKey(project.getKey());
		projectDetails.setProjectId(project.getId());
		projectDetails.setName(project.getName());
		projectDetails.setProjectTypeKey(project.getProjectTypeKey());
		projectDetails.setSelf(project.getSelf());
		
		projectDao.addProject(projectDetails);
		
		issueType.setIssueTypeID(Integer.getInteger(issuetype.getId()));
		issueType.setSelf(issuetype.getSelf());
		issueType.setName(issuetype.getName());
		issueType.setDescription(issuetype.getDescription());
		issueType.setSubtask(issuetype.getSubtask());
		
		issueTypeDao.addIssueType(issueType);
		
		issueDetail.setId(webhookIssue.getId());
		issueDetail.setSelf(webhookIssue.getSelf());
		issueDetail.setKey(webhookIssue.getKey());
		issueDetail.setPriority(webhookIssue.getFields().getPriority().getName());
		issueDetail.setIssueTypeID(Integer.getInteger(webhookIssue.getFields().getIssuetype().getId()));
		issueDetail.setProjectID(webhookIssue.getFields().getProject().getId());
		
		issueDao.addIssue(issueDetail);
		
		comment.setIssueID(webhookIssue.getId());
		comment.setUserId(userdetail.getUserID());
		//comment.setCommentDetails(webhookIssue.getFields().getComment().getComments().get(0));
		comment.setDateTime(new Date(data.getTimestamp()));
		
		commentDao.addComment(comment);
		
		transition.setTransitionId(webhookTransition.getTransitionId());
		transition.setWorkflowId(webhookTransition.getWorkflowId());
		transition.setWorkflowName(webhookTransition.getWorkflowName());
		transition.setIssueId(webhookIssue.getId());
		transition.setFromStatus(webhookTransition.getFrom_status());
		transition.setToStatus(webhookTransition.getTo_status());
		transition.setUserId(userdetail.getUserID());
		transition.setTransitionName(webhookTransition.getTransitionName());
		transition.setTimestamp(new Date(data.getTimestamp()));
		
	}

	@Override
	public void getJiraDataById(Integer id) {
		// TODO Auto-generated method stub

	}

}
