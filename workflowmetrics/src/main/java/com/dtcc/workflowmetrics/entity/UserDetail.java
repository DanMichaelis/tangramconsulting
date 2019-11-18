package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "userDetail")
@Table(name = "UserDetail")
public class UserDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID;

	@Column(name = "Self")
	private String self;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "UserKey")
	private String userKey;

	@Column(name = "EmailId") // , unique=true)
	private String emailId;

	@JsonManagedReference

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Transition> transitions;

	@JsonManagedReference

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Comment> comments;

	@JsonManagedReference

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<TransitionDuration> transitionDurations;

	public List<TransitionDuration> getTransitionDurations() {
		return transitionDurations;
	}

	public void setTransitionDurations(List<TransitionDuration> transitionDurations) {
		// this.transitionDurations = transitionDurations;
		if (this.transitionDurations == null) {
			this.transitionDurations = transitionDurations;
		} else {
			this.transitionDurations.retainAll(transitionDurations);
			this.transitionDurations.addAll(transitionDurations);
		}

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(final List<Transition> transitions) { //
		this.transitions = transitions;
//		if (this.transitions == null) {
//			this.transitions = transitions;
//		} else {
//			this.transitions.retainAll(transitions);
//			this.transitions.addAll(transitions);
//		}

	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		// this.comments = comments;

		if (this.comments == null) {
			this.comments = comments;
		} else {
			this.comments.retainAll(comments);
			this.comments.addAll(comments);
		}

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getKey() {
		return userKey;
	}

	public void setKey(String key) {
		this.userKey = key;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
