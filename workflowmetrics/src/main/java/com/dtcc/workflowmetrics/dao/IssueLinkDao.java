package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.IssueLink;

public interface IssueLinkDao {

	public void addIssueLink(IssueLink issueLink);
	
	public void getIssueLinkById(Integer issueId);


}
