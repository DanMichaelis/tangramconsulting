package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class ProjectDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ProjectId")
	private Integer projectId;

	@Column(name = "ProjectKey")
	private String projectKey;

	@Column(name = "Self")
	private String self;

	@Column(name = "ProjectName")
	private String projectName;

	@Column(name = "ProjectTypeKey")
	private String projectTypeKey;

	/*
	 * @JsonManagedReference
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval =
	 * true) private List<Issue> issues;
	 * 
	 * @JsonManagedReference
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval =
	 * true) private List<TransitionDuration> transitionDurations;
	 * 
	 * @JsonManagedReference
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval =
	 * true) private List<TStatusDuration> tStatusDuration;
	 */

	public Integer getProjectId() {
		return projectId;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/*
	 * public List<Issue> getIssues() { return issues; }
	 * 
	 * public void setIssues(List<Issue> issues) { // this.issues = issues; if
	 * (this.issues == null) { this.issues = issues; } else {
	 * this.issues.retainAll(issues); this.issues.addAll(issues); }
	 * 
	 * }
	 * 
	 * public List<TransitionDuration> getTransitionDurations() { return
	 * transitionDurations; }
	 * 
	 * public void setTransitionDurations(List<TransitionDuration>
	 * transitionDurations) { // this.transitionDurations = transitionDurations; if
	 * (this.transitionDurations == null) { this.transitionDurations =
	 * transitionDurations; } else {
	 * this.transitionDurations.retainAll(transitionDurations);
	 * this.transitionDurations.addAll(transitionDurations); } }
	 * 
	 * public List<TStatusDuration> gettStatusDuration() { return tStatusDuration; }
	 * 
	 * public void settStatusDuration(List<TStatusDuration> tStatusDuration) { //
	 * this.tStatusDuration = tStatusDuration; if (this.tStatusDuration == null) {
	 * this.tStatusDuration = tStatusDuration; } else {
	 * this.tStatusDuration.retainAll(tStatusDuration);
	 * this.tStatusDuration.addAll(tStatusDuration); } }
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getKey() {
		return projectKey;
	}

	public void setKey(String key) {
		this.projectKey = key;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getName() {
		return projectKey;
	}

	public void setName(String name) {
		this.projectKey = name;
	}

	public String getProjectTypeKey() {
		return projectTypeKey;
	}

	public void setProjectTypeKey(String projectTypeKey) {
		this.projectTypeKey = projectTypeKey;
	}

	public ProjectDetails(Integer projectId, String key, String self, String name, String projectTypeKey) {
		super();
		this.projectId = projectId;
		this.projectKey = key;
		this.self = self;
		this.projectKey = name;
		this.projectTypeKey = projectTypeKey;
	}

	public ProjectDetails() {
	}

}
