package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;

	@Column(name = "Self")
	private String self;

	@Column(name = "Name")
	private String name;

	@Column(name = "Key")
	private String key;

	@Column(name = "EmailId")
	private String emailId;

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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserDetail(Integer userID, String self, String name, String key, String emailId) {
		super();
		this.userID = userID;
		this.self = self;
		this.name = name;
		this.key = key;
		this.emailId = emailId;
	}

	public UserDetail() {
	}

}
