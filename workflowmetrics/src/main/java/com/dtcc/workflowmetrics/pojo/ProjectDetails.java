package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class ProjectDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ProjectId")
	private Integer projectId;

	@Column(name = "Key")
	private String key;

	@Column(name = "Self")
	private String self;

	@Column(name = "Name")
	private String name;

	@Column(name = "ProjectTypeKey")
	private String projectTypeKey;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public String getProjectTypeKey() {
		return projectTypeKey;
	}

	public void setProjectTypeKey(String projectTypeKey) {
		this.projectTypeKey = projectTypeKey;
	}

	public ProjectDetails(Integer projectId, String key, String self, String name, String projectTypeKey) {
		super();
		this.projectId = projectId;
		this.key = key;
		this.self = self;
		this.name = name;
		this.projectTypeKey = projectTypeKey;
	}

	public ProjectDetails() {
	}


}
