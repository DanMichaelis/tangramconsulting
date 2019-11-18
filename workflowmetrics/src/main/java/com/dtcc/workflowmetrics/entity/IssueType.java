package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "issueType")
@Table(name = "Issue_Type")
public class IssueType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IssueTypeID")
	private Integer issueTypeID;

	@Column(name = "Self")
	private String self;

	@Column(name = "Description")
	private String description;

	@Column(name = "IssueName")
	private String issueName;

	@Column(name = "Subtask")
	private Boolean subtask;

	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Issue> issues;

	
	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIssueTypeID() {
		return issueTypeID;
	}

	public void setIssueTypeID(Integer issueTypeID) {
		this.issueTypeID = issueTypeID;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return issueName;
	}

	public void setName(String name) {
		this.issueName = name;
	}

	public Boolean getSubtask() {
		return subtask;
	}

	public void setSubtask(Boolean subtask) {
		this.subtask = subtask;
	}

	public IssueType(Integer issueTypeID, String self, String description, String name, Boolean subtask) {
		super();
		this.issueTypeID = issueTypeID;
		this.self = self;
		this.description = description;
		this.issueName = name;
		this.subtask = subtask;
	}

	public IssueType() {
		super();
	}

	
}
