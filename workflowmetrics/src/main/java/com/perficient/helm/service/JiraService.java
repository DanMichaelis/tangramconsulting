package com.perficient.helm.service;

import com.perficient.helm.events.jira.webhook.WebhookData;

public interface JiraService {

	public void addJiraData(WebhookData data);
	
	public void getJiraDataById(Integer id);


}
