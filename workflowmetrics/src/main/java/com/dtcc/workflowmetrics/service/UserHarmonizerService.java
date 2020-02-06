package com.dtcc.workflowmetrics.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.workflowmetrics.entity.EventUser;
import com.dtcc.workflowmetrics.entity.EventUserCustomField;
import com.dtcc.workflowmetrics.entity.MetricsItems;
import com.dtcc.workflowmetrics.entity.MetricsItemsCustomField;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransition;
import com.dtcc.workflowmetrics.metricsitems.jira.common.CustomField;
import com.dtcc.workflowmetrics.metricsitems.jira.common.User;
import com.dtcc.workflowmetrics.metricsitems.jira.issue.Issue;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookIssue;
import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookTransition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserHarmonizerService {

	@Transactional
	public final MetricsItems harmonizeJira(WebhookData data) {

		EventUser eventUser = harmonizeJiraUser(data.getUser());

		MetricsItems metricItem = harmonizeJiraIssue(data.getTransition(), data.getIssue());
		return metricItem;

	}

	@Transactional
	public final MetricsItems harmonizeIssue(Issue issue) {

		int source = 12;
		MetricsItems item = new MetricsItems();

		item.setItemId(issue.getId());
		item.setSourceSystemId(source);
		item.setProjectId(issue.getKey());
		item.setItemKey(issue.getKey());
		item.setItemSummary(null);
		item.setItemDescription(issue.getFields().getDescription());
		item.setItemCreateDate(Long.getLong(issue.getFields().getCreated()));
		item.setItemCreator(issue.getFields().getUser().getName());
		item.setLastUpdateDate(null);
		item.setLastUpdateUser(issue.getFields().getLastViewed());

		MetricsItemsTStatusTransition tStatusTransition = new MetricsItemsTStatusTransition();

		/*
		 * tStatusTransition.setItemId(issue.getId());
		 * tStatusTransition.setProjectId(issue.getKey());
		 * tStatusTransition.setSourceSystemId(source);
		 * tStatusTransition.setStatus(Integer.getInteger(issue.getFields().getStatus().
		 * getId()));
		 * tStatusTransition.setTransitionDate(Long.getLong(issue.getFields().getCreated
		 * ()));
		 * 
		 * item.addTStatusTransition(tStatusTransition);
		 * 
		 * MetricsItemsStatusTransition statusTransition = new
		 * MetricsItemsStatusTransition();
		 * 
		 * statusTransition.setItemId(transition.getTransitionId().toString());
		 * statusTransition.setProjectId(issue.getFields().getProject().getId().toString
		 * ()); statusTransition.setSourceSystemId(source);
		 * statusTransition.setFromStatus(transition.getFrom_status());
		 * statusTransition.setToStatus(transition.getTo_status());
		 * statusTransition.setTransitionDate(Long.getLong(issue.getFields().getCreated(
		 * )));
		 * 
		 * item.addStatusTransition(statusTransition);
		 */

		ArrayList<CustomField> custField = issue.getFields().getCustomFields();

		for (CustomField cust : custField) {

			MetricsItemsCustomField metricCustomField = new MetricsItemsCustomField();

			metricCustomField.setItemId(issue.getId());
			metricCustomField.setSourceSystemId(source);
			metricCustomField.setFieldName(cust.getSelf());
			metricCustomField.setFieldDatatype("CustomField");
			metricCustomField.setFieldValue(cust.getValue());
			metricCustomField.setCreateDate(Long.getLong(issue.getFields().getCreated()));

			item.addCustomField(metricCustomField);
		}

		return item;

	}

	protected final MetricsItems harmonizeJiraIssue(WebhookTransition transition, WebhookIssue issue) {

		int source = 12;
		MetricsItems item = new MetricsItems();

		item.setItemId(transition.getTransitionId().toString());
		item.setSourceSystemId(source);
		item.setProjectId(issue.getFields().getProject().getId().toString());
		item.setItemKey(issue.getFields().getCreator().getKey());
		item.setItemSummary(issue.getFields().getSummary());
		item.setItemDescription(issue.getFields().getDescription());
		item.setItemCreateDate(Long.getLong(issue.getFields().getCreated()));
		item.setItemCreator(issue.getFields().getCreator().getName());
		item.setLastUpdateDate(null);
		item.setLastUpdateUser(issue.getFields().getLastViewed());

		MetricsItemsTStatusTransition tStatusTransition = new MetricsItemsTStatusTransition();

		tStatusTransition.setItemId(transition.getTransitionId().toString());
		tStatusTransition.setProjectId(issue.getFields().getProject().getId().toString());
		tStatusTransition.setSourceSystemId(source);
		tStatusTransition.setStatus(0);//Integer.getInteger(issue.getFields().getStatus().getId()));
		tStatusTransition.setTransitionDate(Long.getLong(issue.getFields().getCreated()));

		item.addTStatusTransition(tStatusTransition);

		MetricsItemsStatusTransition statusTransition = new MetricsItemsStatusTransition();

		statusTransition.setItemId(transition.getTransitionId().toString());
		statusTransition.setProjectId(issue.getFields().getProject().getId().toString());
		statusTransition.setSourceSystemId(source);
		statusTransition.setFromStatus(transition.getFrom_status());
		statusTransition.setToStatus(transition.getTo_status());
		statusTransition.setTransitionDate(Long.getLong(issue.getFields().getCreated()));

		item.addStatusTransition(statusTransition);

		Map<String, CustomField> custField = issue.getFields().getCustomFields();

		ObjectMapper objectMapper = new ObjectMapper();
		for (Map.Entry<String, CustomField> cust : custField.entrySet()) {

			MetricsItemsCustomField metricCustomField = new MetricsItemsCustomField();

			metricCustomField.setItemId(transition.getTransitionId().toString());
			metricCustomField.setSourceSystemId(source);
			metricCustomField.setFieldName(cust.getKey());
			metricCustomField.setFieldDatatype("CustomField");
			try {
				metricCustomField.setFieldValue(objectMapper.writeValueAsString(cust.getValue()));
			} catch (JsonProcessingException e) {
				System.out.println("JSON writing error");
			}
			metricCustomField.setCreateDate(Long.getLong(issue.getFields().getCreated()));

			item.addCustomField(metricCustomField);
		}

		return item;
	}

	protected final EventUser harmonizeJiraUser(User user) {

		int source = 12;
		EventUser evntUsr = new EventUser();

		evntUsr.setId(user.getKey());
		evntUsr.setEmailId(user.getEmailAddress());
		evntUsr.setUserName(user.getName());
		evntUsr.setSourceSystem(source);

		evntUsr.setLastUpdateDate(setLastUpdateDateforJira(user));

		String checksum = user.getKey() + Integer.toString(source) + user.getEmailAddress() + user.getName();

		ArrayList<EventUserCustomField> fields = new ArrayList<EventUserCustomField>();

		EventUserCustomField field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(),
				"avatarUrls", "Hashmap", "ConvertAvatarHashmaptoString");
		fields.add(field);
		checksum = checksum + "avatarUrls" + "Hashmap" + "ConvertAvatarHashmaptoString";

		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "displayName", "String",
				user.getDisplayName());
		fields.add(field);

		checksum = checksum + "displayName" + "String" + user.getDisplayName();

		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "active", "Boolean",
				user.getActive().toString());
		fields.add(field);

		checksum = checksum + "active" + "Boolean" + user.getActive().toString();

		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "timeZone", "String",
				user.getTimeZone());
		fields.add(field);

		checksum = checksum + "timeZone" + "String" + user.getTimeZone();

		evntUsr.setCheckSum(checksum);

		evntUsr.setEventUserCustomField(fields);

		return evntUsr;

	}

	private Long setLastUpdateDateforJira(User user) {
		return System.currentTimeMillis();
	}
}
