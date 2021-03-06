package com.perficient.helm.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.helm.entity.EventUser;
import com.perficient.helm.entity.EventUserCustomField;
import com.perficient.helm.entity.MetricsItems;
import com.perficient.helm.entity.MetricsItemsCustomField;
import com.perficient.helm.entity.MetricsItemsStatusTransition;
import com.perficient.helm.entity.MetricsItemsTStatusTransition;
import com.perficient.helm.events.jira.common.CustomField;
import com.perficient.helm.events.jira.common.User;
import com.perficient.helm.events.jira.issue.Issue;
import com.perficient.helm.events.jira.webhook.WebhookData;
import com.perficient.helm.events.jira.webhook.WebhookIssue;
import com.perficient.helm.events.jira.webhook.WebhookTransition;

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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Date ctTime = new Date(0);
		try {
			ctTime = sdf.parse(issue.getFields().getCreated());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		long createTime = ctTime.getTime();

		item.setSourceSystemId(source);
		item.setProjectId(issue.getKey());
		item.setItemKey(issue.getKey());
		item.setItemSummary(null);
		item.setItemDescription(issue.getFields().getDescription());
		item.setItemCreateDate(createTime);
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
			metricCustomField.setCreateDate(createTime);

			item.addCustomField(metricCustomField);
		}

		return item;

	}

	protected final MetricsItems harmonizeJiraIssue(WebhookTransition transition, WebhookIssue issue) {

		int source = 12;
		MetricsItems item = new MetricsItems();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Date ctTime = new Date(0);
		try {
			ctTime = sdf.parse(issue.getFields().getCreated());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		long createTime = ctTime.getTime();

		Date ltTime = new Date(0);

		long lastUpdateTime;

		if (issue.getFields().getLastViewed() != null) {
			try {
				ltTime = (Date) sdf.parseObject(issue.getFields().getLastViewed());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lastUpdateTime = ltTime.getTime();
		} else {
			lastUpdateTime = createTime;
		}

		item.setSourceSystemId(source);
		item.setProjectId(issue.getFields().getProject().getKey().toString());
		item.setItemKey(issue.getKey());
		item.setItemSummary(issue.getFields().getSummary());
		item.setItemDescription(issue.getFields().getDescription());
		item.setItemCreateDate(createTime);
		item.setItemCreator(issue.getFields().getCreator().getName());
		item.setLastUpdateDate(lastUpdateTime);

		item.setLastUpdateUser(issue.getFields().getCreator().getName()); // TODO check for value

		MetricsItemsTStatusTransition tStatusTransition = new MetricsItemsTStatusTransition();

		tStatusTransition.setItemId(item.getItemId());
		tStatusTransition.setProjectId(issue.getFields().getProject().getKey().toString());
		tStatusTransition.setSourceSystemId(source);
		tStatusTransition.setStatus(0);// Integer.getInteger(issue.getFields().getStatus().getId()));
		tStatusTransition.setTransitionDate(lastUpdateTime);

		item.addTStatusTransition(tStatusTransition);

		MetricsItemsStatusTransition statusTransition = new MetricsItemsStatusTransition();

		statusTransition.setItemId(item.getItemId());
		statusTransition.setProjectId(issue.getFields().getProject().getKey().toString());
		statusTransition.setSourceSystemId(source);
		statusTransition.setFromStatus(transition.getFrom_status());
		statusTransition.setToStatus(transition.getTo_status());
		statusTransition.setTransitionDate(lastUpdateTime);

		item.addStatusTransition(statusTransition);

		Map<String, CustomField> custField = issue.getFields().getCustomFields();

		for (Map.Entry<String, CustomField> cust : custField.entrySet()) {

			MetricsItemsCustomField metricCustomField = new MetricsItemsCustomField();

			metricCustomField.setItemId(item.getItemId());
			metricCustomField.setSourceSystemId(source);
			metricCustomField.setFieldName(cust.getKey());
			metricCustomField.setFieldDatatype("CustomField");
			metricCustomField.setFieldValue(cust.getValue().getValue());

			metricCustomField.setCreateDate(lastUpdateTime);

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
