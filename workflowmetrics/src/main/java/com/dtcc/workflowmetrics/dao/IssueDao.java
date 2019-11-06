package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.Issue;

public interface IssueDao {

	public void addIssue(Issue issue);
	
	public void getIssueById(Integer issueId);

}
