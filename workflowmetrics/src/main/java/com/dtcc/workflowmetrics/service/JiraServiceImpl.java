package com.dtcc.workflowmetrics.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.dtcc.workflowmetrics.entity.Comment;
import com.dtcc.workflowmetrics.entity.Issue;
import com.dtcc.workflowmetrics.entity.IssueType;
import com.dtcc.workflowmetrics.entity.ProjectDetails;
import com.dtcc.workflowmetrics.entity.Transition;
import com.dtcc.workflowmetrics.entity.UserDetail;
import com.dtcc.workflowmetrics.metricsitems.jira.common.Issuetype;
import com.dtcc.workflowmetrics.metricsitems.jira.common.Project;
import com.dtcc.workflowmetrics.metricsitems.jira.common.User;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookIssue;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookTransition;

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
	@Transactional
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
		
		Integer issueId = webhookIssue.getId();
		Integer projectId = project.getId();

		userdetail.setSelf(user.getSelf());
		userdetail.setUserName(user.getName());
		userdetail.setUserKey(user.getKey());
		userdetail.setEmailId(user.getEmailAddress());

		userDao.save(userdetail);

		projectDetails.setProjectKey(project.getKey());
		projectDetails.setProjectId(projectId);
		projectDetails.setProjectName(project.getName());
		projectDetails.setProjectTypeKey(project.getProjectTypeKey());
		projectDetails.setSelf(project.getSelf());

		projectDao.save(projectDetails);

		issueType.setIssueTypeID(issuetype.getId());
		issueType.setSelf(issuetype.getSelf());
		issueType.setName(issuetype.getName());
		issueType.setDescription(issuetype.getDescription());
		issueType.setSubtask(issuetype.getSubtask());

		issueTypeDao.save(issueType);

		issueDetail.setId(issueId);
		issueDetail.setSelf(webhookIssue.getSelf());
		issueDetail.setKey(webhookIssue.getKey());
		issueDetail.setPriority(webhookIssue.getFields().getPriority().getName());
		issueDetail.setIssueTypeID(webhookIssue.getFields().getIssuetype().getId());
		issueDetail.setProjectID(projectId);

		issueDao.save(issueDetail);

		comment.setIssueID(issueId);
		comment.setUserId(userdetail.getUserID());
		// comment.setCommentDetails(webhookIssue.getFields().getComment().getComments().get(0));
		comment.setDateTime(new Date(data.getTimestamp()));

		commentDao.save(comment);

		transition.setTransitionId(webhookTransition.getTransitionId());
		transition.setWorkflowId(webhookTransition.getWorkflowId());
		transition.setWorkflowName(webhookTransition.getWorkflowName());
		transition.setIssueId(issueId);
		transition.setFromStatus(webhookTransition.getFrom_status());
		transition.setToStatus(webhookTransition.getTo_status());
		//transition.setUserId();
		transition.setTransitionName(webhookTransition.getTransitionName());
		transition.setTimestamp(new Date(data.getTimestamp()));

		transitionDao.save(transition);

	}

	@Override
	public void getJiraDataById(Integer id) {
		// TODO Auto-generated method stub

	}

}
