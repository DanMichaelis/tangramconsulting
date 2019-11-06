package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TransitionDuration")
public class TransitionDuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IssueID")
	private Integer issueID;

	@Column(name = "Status")
	private String status;
	
	@Column(name = "DurationInStatus")
	private String durationInStatus;
	
	@Column(name = "UserId")
	private Integer userId;

	@Column(name = "StartDateTime")
	private Date startDateTime;
	
	@Column(name = "EndDateTime")
	private Date endDateTime;
	
	@Column(name = "ProjectID")
	private Integer projectID;

	@Column(name = "SysID")
	private Integer  sysID;
	
	@Column(name = "TStatus")
	private String TStatus;

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
