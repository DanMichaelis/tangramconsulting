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
@Table(name = "TransitionDuration")
public class TransitionDuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transitionDurationId;

	@JsonBackReference

	@OneToOne(cascade = CascadeType.MERGE)

	@JoinColumn(name = "IssueID", referencedColumnName = "IssueID")
	private Issue issue;

	@Column(name = "IssueID", insertable = false, updatable = false)
	private Integer issueID;

	@Column(name = "Status")
	private String status;

	@Column(name = "DurationInStatus")
	private String durationInStatus;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "UserID", referencedColumnName = "UserID")
	private UserDetail userDetail;

	@Column(name = "UserID", insertable = false, updatable = false)
	private int userId;

	@Column(name = "StartDateTime")
	private Date startDateTime;

	@Column(name = "EndDateTime")
	private Date endDateTime;

	@JsonBackReference

	@OneToOne(cascade = CascadeType.MERGE)

	@JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
	private ProjectDetails projectDetail;

	@Column(name = "ProjectID", insertable = false, updatable = false)
	private int projectID;

	@Column(name = "SysID")
	private Integer sysID;

	@Column(name = "TStatus")
	private String TStatus;

	public Integer getTransitionDurationId() {
		return transitionDurationId;
	}

	public void setTransitionDurationId(Integer transitionDurationId) {
		this.transitionDurationId = transitionDurationId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public ProjectDetails getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetails projectDetail) {
		this.projectDetail = projectDetail;
	}

	public Integer getIssueID() {
		return issueID;
	}

	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDurationInStatus() {
		return durationInStatus;
	}

	public void setDurationInStatus(String durationInStatus) {
		this.durationInStatus = durationInStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Integer getSysID() {
		return sysID;
	}

	public void setSysID(Integer sysID) {
		this.sysID = sysID;
	}

	public String getTStatus() {
		return TStatus;
	}

	public void setTStatus(String tStatus) {
		TStatus = tStatus;
	}

	public TransitionDuration(Integer issueID, String status, String durationInStatus, Integer userId,
			Date startDateTime, Date endDateTime, Integer projectID, Integer sysID, String tStatus) {
		super();
		this.issueID = issueID;
		this.status = status;
		this.durationInStatus = durationInStatus;
		this.userId = userId;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.projectID = projectID;
		this.sysID = sysID;
		TStatus = tStatus;
	}

	public TransitionDuration() {
	}

}
