package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.IssueType;

public interface IssueTypeDao {

	public void addIssueType(IssueType issueType);
	
	public void getIssueTypeById(Integer issueTypeId);


}
