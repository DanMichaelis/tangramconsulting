package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Issue")
public class Issue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "self")
	private String self;

	@Column(name = "key")
	private String key;

	@Column(name = "IssueTypeID")
	private Integer issueTypeID;

	@Column(name = "ProjectID")
	private Integer projectID;

	@Column(name = "Priority")
	private String priority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getIssueTypeID() {
		return issueTypeID;
	}

	public void setIssueTypeID(Integer issueTypeID) {
		this.issueTypeID = issueTypeID;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Issue(Integer id, String self, String key, Integer issueTypeID, Integer projectID, String priority) {
		super();
		this.id = id;
		this.self = self;
		this.key = key;
		this.issueTypeID = issueTypeID;
		this.projectID = projectID;
		this.priority = priority;
	}

	public Issue() {
	}

	
}
