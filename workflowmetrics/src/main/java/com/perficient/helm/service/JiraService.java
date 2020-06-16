package com.dtcc.workflowmetrics.service;

import com.dtcc.workflowmetrics.metricsitems.jira.webhook.WebhookData;

public interface JiraService {

	public void addJiraData(WebhookData data);
	
	public void getJiraDataById(Integer id);


}
