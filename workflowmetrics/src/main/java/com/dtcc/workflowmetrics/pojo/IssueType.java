package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IssueType")
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

	@Column(name = "Name")
	private String name;

	@Column(name = "Subtask")
	private Boolean subtask;

	
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.name = name;
		this.subtask = subtask;
	}

	public IssueType() {
		super();
	}

	
}
