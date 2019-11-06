package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TStatusDuration")
public class TStatusDuration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IssueID")
	private Integer issueID;

	@Column(name = "DurationInStatus")
	private String durationInStatus;

	@Column(name = "ProjectID")
	private Integer projectID;

	@Column(name = "SysID")
	private Integer sysID;

	@Column(name = "TStatus")
	private String TStatus;

	public Integer getIssueID() {
		return issueID;
	}

	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}

	public String getDurationInStatus() {
		return durationInStatus;
	}

	public void setDurationInStatus(String durationInStatus) {
		this.durationInStatus = durationInStatus;
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

	public TStatusDuration(Integer issueID, String durationInStatus, Integer projectID, Integer sysID, String tStatus) {
		super();
		this.issueID = issueID;
		this.durationInStatus = durationInStatus;
		this.projectID = projectID;
		this.sysID = sysID;
		TStatus = tStatus;
	}

	public TStatusDuration() {
	}

}
