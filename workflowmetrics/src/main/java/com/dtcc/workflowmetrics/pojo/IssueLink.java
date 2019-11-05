package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IssueLink")
public class IssueLink implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IssueID")
	private Integer issueID;

	@Column(name = "LinkedIssueId")
	private String linkedIssueId;

	@Column(name = "LinkRelationship")
	private String linkRelationship;

	public Integer getIssueID() {
		return issueID;
	}

	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}

	public String getLinkedIssueId() {
		return linkedIssueId;
	}

	public void setLinkedIssueId(String linkedIssueId) {
		this.linkedIssueId = linkedIssueId;
	}

	public String getLinkRelationship() {
		return linkRelationship;
	}

	public void setLinkRelationship(String linkRelationship) {
		this.linkRelationship = linkRelationship;
	}

	public IssueLink(Integer issueID, String linkedIssueId, String linkRelationship) {
		super();
		this.issueID = issueID;
		this.linkedIssueId = linkedIssueId;
		this.linkRelationship = linkRelationship;
	}

	public IssueLink() {
	}

}
