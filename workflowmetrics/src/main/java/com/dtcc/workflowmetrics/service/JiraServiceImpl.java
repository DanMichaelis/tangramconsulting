package com.dtcc.workflowmetrics.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

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
import com.dtcc.workflowmetrics.entity.FieldsData;
import com.dtcc.workflowmetrics.entity.Issue;
import com.dtcc.workflowmetrics.entity.IssueType;
import com.dtcc.workflowmetrics.entity.ProjectDetails;
import com.dtcc.workflowmetrics.entity.Transition;
import com.dtcc.workflowmetrics.entity.UserDetail;
import com.dtcc.workflowmetrics.metricsitems.jira.common.CustomField;
import com.dtcc.workflowmetrics.metricsitems.jira.common.Issuetype;
import com.dtcc.workflowmetrics.metricsitems.jira.common.Project;
import com.dtcc.workflowmetrics.metricsitems.jira.common.User;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookIssue;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookTransition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

		Map<String, CustomField> cusMap = new LinkedHashMap<>();

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

		Optional<UserDetail> searchUserDetail = userDao.findByEmailId(user.getEmailAddress());

		if (searchUserDetail != null && searchUserDetail.isPresent()) {

			userdetail = searchUserDetail.get();
		}

		userdetail.setSelf(user.getSelf());
		userdetail.setUserName(user.getName());
		userdetail.setUserKey(user.getKey());
		userdetail.setEmailId(user.getEmailAddress());

		Optional<ProjectDetails> searchProjectDetail = projectDao.findById(projectId);

		if (searchProjectDetail != null && searchProjectDetail.isPresent()) {

			projectDetails = searchProjectDetail.get();
		}

		projectDetails.setProjectKey(project.getKey());
		projectDetails.setProjectId(projectId);
		projectDetails.setProjectName(project.getName());
		projectDetails.setProjectTypeKey(project.getProjectTypeKey());
		projectDetails.setSelf(project.getSelf());

		Optional<IssueType> searchIssueType = issueTypeDao.findById(issuetype.getId());

		if (searchIssueType != null && searchIssueType.isPresent()) {

			issueType = searchIssueType.get();
		}

		issueType.setIssueTypeID(issuetype.getId());
		issueType.setSelf(issuetype.getSelf());
		issueType.setName(issuetype.getName());
		issueType.setDescription(issuetype.getDescription());
		issueType.setSubtask(issuetype.getSubtask());

		IssueType storedIssueType = issueTypeDao.save(issueType);

		ProjectDetails storedProjectDetail = projectDao.save(projectDetails);

		UserDetail storedUserDetail = userDao.save(userdetail);

		Optional<Issue> searchIssueDetail = issueDao.findById(issueId);

		if (searchIssueDetail != null && searchIssueDetail.isPresent()) {

			issueDetail = searchIssueDetail.get();
		}

		issueDetail.setId(issueId);
		issueDetail.setSelf(webhookIssue.getSelf());
		issueDetail.setKey(webhookIssue.getKey());
		issueDetail.setPriority(webhookIssue.getFields().getPriority().getName());
		issueDetail.setIssueType(storedIssueType);
		issueDetail.setProjectDetail(storedProjectDetail);

		Issue storedIssue = issueDao.save(issueDetail);

		comment.setIssue(storedIssue);
		comment.setUserDetail(storedUserDetail);
		// comment.setCommentDetails(webhookIssue.getFields().getComment().getComments().get(0));
		comment.setDateTime(new Date(data.getTimestamp()));

		commentDao.save(comment);

		Optional<Transition> searchTransitionDetail = transitionDao.findById(webhookTransition.getTransitionId());

		if (searchTransitionDetail != null && searchTransitionDetail.isPresent()) {

			transition = searchTransitionDetail.get();
		}
		transition.setTransitionId(webhookTransition.getTransitionId());
		transition.setWorkflowId(webhookTransition.getWorkflowId());
		transition.setWorkflowName(webhookTransition.getWorkflowName()); //
		// transition.setIssueId(issueId);
		transition.setIssue(storedIssue);
		transition.setFromStatus(webhookTransition.getFrom_status());
		transition.setToStatus(webhookTransition.getTo_status());
		transition.setUserDetail(storedUserDetail);
		transition.setTransitionName(webhookTransition.getTransitionName());
		transition.setTimestamp(new Date(data.getTimestamp()));

		transitionDao.save(transition);

		cusMap = data.getIssue().getFields().getCustomFields();
		ObjectMapper objectMapper = new ObjectMapper();
		for (Map.Entry<String, CustomField> cust : cusMap.entrySet()) {

			FieldsData fieldsData = new FieldsData();
			String key = cust.getKey();
			CustomField val = cust.getValue();

			Optional<FieldsData> searchFieldsData = fieldsDao.findByIssueIDAndFieldName(issueId, key);
			if (searchFieldsData != null && searchFieldsData.isPresent()) {

				fieldsData = searchFieldsData.get();
			}
			fieldsData.setIssue(storedIssue);
			fieldsData.setFieldDatatype("CustomField");
			fieldsData.setFieldName(key);

			try {
				fieldsData.setFieldValue(objectMapper.writeValueAsString(val));
			} catch (JsonProcessingException e) {
				System.out.println("JSON writing error");
			}
			fieldsData.setDt(new Date(data.getTimestamp()));

			fieldsDao.save(fieldsData);
		}

	}

	@Override
	public void getJiraDataById(Integer id) {
		// TODO Auto-generated method stub

	}

}
