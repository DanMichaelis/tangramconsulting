package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TStatusDuration")
public class TStatusDuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tStatusDurationId;

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

	@Column(name = "DurationInStatus")
	private String durationInStatus;

	/*
	 * @JsonBackReference
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID") private
	 * ProjectDetails projectDetail;
	 * 
	 * @Column(name = "ProjectID", insertable = false, updatable = false)
	 */
	@Column(name = "ProjectID")
	private int projectID;

	@Column(name = "SysID")
	private Integer sysID;

	@Column(name = "TStatus")
	private String TStatus;

	public Integer gettStatusDurationId() {
		return tStatusDurationId;
	}

	public void settStatusDurationId(Integer tStatusDurationId) {
		this.tStatusDurationId = tStatusDurationId;
	}

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
