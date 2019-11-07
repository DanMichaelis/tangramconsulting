package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "issue")
@Table(name = "Issue")
public class Issue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IssueID")
	private Integer issueId;

	@Column(name = "Self")
	private String self;

	@Column(name = "IssueKey")
	private String issueKey;

	@Column(name = "IssueTypeID")
	private Integer issueTypeID;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
	private ProjectDetails projectDetail;

	@Column(name = "ProjectID", insertable = false, updatable = false)
	private int projectID;

	@Column(name = "Priority")
	private String priority;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Fields> fields;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<IssueLink> issueLink;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transition> transitions;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TransitionDuration> transitionDurations;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TStatusDuration> tStatusDuration;

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public String getIssueKey() {
		return issueKey;
	}

	public void setIssueKey(String issueKey) {
		this.issueKey = issueKey;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
//		this.comments = comments;
		if (this.comments == null) {
			this.comments = comments;
		} else {
			this.comments.retainAll(comments);
			this.comments.addAll(comments);
		}

	}

	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(List<Fields> fields) {
//		this.fields = fields;
		if (this.fields == null) {
			this.fields = fields;
		} else {
			this.fields.retainAll(fields);
			this.fields.addAll(fields);
		}

	}

	public List<IssueLink> getIssueLink() {
		return issueLink;
	}

	public void setIssueLink(List<IssueLink> issueLink) {
		this.issueLink = issueLink;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		// this.transitions = transitions;
		if (this.transitions == null) {
			this.transitions = transitions;
		} else {
			this.transitions.retainAll(transitions);
			this.transitions.addAll(transitions);
		}

	}

	public List<TransitionDuration> getTransitionDurations() {
		return transitionDurations;
	}

	public void setTransitionDurations(List<TransitionDuration> transitionDurations) {
//		this.transitionDurations = transitionDurations;
		if (this.transitionDurations == null) {
			this.transitionDurations = transitionDurations;
		} else {
			this.transitionDurations.retainAll(transitionDurations);
			this.transitionDurations.addAll(transitionDurations);
		}

	}

	public List<TStatusDuration> gettStatusDuration() {
		return tStatusDuration;
	}

	public void settStatusDuration(List<TStatusDuration> tStatusDuration) {
//		this.tStatusDuration = tStatusDuration;
		if (this.tStatusDuration == null) {
			this.tStatusDuration = tStatusDuration;
		} else {
			this.tStatusDuration.retainAll(tStatusDuration);
			this.tStatusDuration.addAll(tStatusDuration);
		}

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return issueId;
	}

	public void setId(Integer id) {
		this.issueId = id;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getKey() {
		return issueKey;
	}

	public void setKey(String key) {
		this.issueKey = key;
	}

	public Integer getIssueTypeID() {
		return issueTypeID;
	}

	public void setIssueTypeID(Integer issueTypeID) {
		this.issueTypeID = issueTypeID;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
