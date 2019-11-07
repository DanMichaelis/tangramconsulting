package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TransitionTable")
public class Transition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WorkflowId")
	private Integer workflowId;

	@Column(name = "workflowName")
	private String workflowName;

	@Column(name = "WebhookId")
	private Integer webhookId;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserID", referencedColumnName = "UserID")
	private UserDetail userDetail;

	@Column(name = "UserID", insertable = false, updatable = false)
	private int userId;

	@Column(name = "TransitionName")
	private String transitionName;

	@Column(name = "TransitionId")
	private Integer transitionId;

	@Column(name = "ToStatus")
	private String toStatus;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IssueID", referencedColumnName = "IssueID")
	private Issue issue;

	@Column(name = "IssueID", insertable = false, updatable = false)
	private Integer issueID;

	@Column(name = "FromStatus")
	private String fromStatus;

	@Column(name = "Timestamp")
	private Date Timestamp;

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public Integer getWebhookId() {
		return webhookId;
	}

	public void setWebhookId(Integer webhookId) {
		this.webhookId = webhookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTransitionName() {
		return transitionName;
	}

	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}

	public Integer getTransitionId() {
		return transitionId;
	}

	public void setTransitionId(Integer transitionId) {
		this.transitionId = transitionId;
	}

	public String getToStatus() {
		return toStatus;
	}

	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	public Integer getIssueId() {
		return issueID;
	}

	public void setIssueId(Integer issueId) {
		this.issueID = issueId;
	}

	public String getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public Transition() {
	}

	public Transition(String workflowName, Integer workflowId, Integer webhookId, Integer userId, String transitionName,
			Integer transitionId, String toStatus, Integer issueId, String fromStatus, Date timestamp) {
		super();
		this.workflowName = workflowName;
		this.workflowId = workflowId;
		this.webhookId = webhookId;
		this.userId = userId;
		this.transitionName = transitionName;
		this.transitionId = transitionId;
		this.toStatus = toStatus;
		this.issueID = issueId;
		this.fromStatus = fromStatus;
		Timestamp = timestamp;
	}

}
