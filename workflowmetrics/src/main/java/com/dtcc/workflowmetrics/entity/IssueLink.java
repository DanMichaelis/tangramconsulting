package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "issueLink")
@Table(name = "IssueLink")
public class IssueLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer issueLinkId;

	/*
	 * @JsonBackReference
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "IssueID", referencedColumnName = "IssueID") private Issue
	 * issue;
	 * 
	 * @Column(name = "IssueID", insertable = false, updatable = false)
	 */
	@Column(name = "IssueID")
	private Integer issueID;

	@Column(name = "LinkedIssueId")
	private String linkedIssueId;

	@Column(name = "LinkRelationship")
	private String linkRelationship;

	public Integer getIssueLinkId() {
		return issueLinkId;
	}

	public void setIssueLinkId(Integer issueLinkId) {
		this.issueLinkId = issueLinkId;
	}

	/*
	 * public Issue getIssue() { return issue; }
	 * 
	 * public void setIssue(Issue issue) { this.issue = issue; }
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

}
