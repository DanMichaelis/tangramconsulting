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

@Entity(name = "fields")
@Table(name = "Fields")
public class FieldsData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fieldId;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "IssueID", referencedColumnName = "IssueID")
	private Issue issue;

	@Column(name = "IssueID", insertable = false, updatable = false)
	private Integer issueID;

	@Column(name = "FieldName")
	private String fieldName;

	@Column(name = "FieldValue", length = 5000)
	private String fieldValue;

	@Column(name = "FieldDatatype")
	private String fieldDatatype;

	@Column(name = "CreationDate")
	private Date dt;

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIssueID() {
		return issueID;
	}

	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getFieldDatatype() {
		return fieldDatatype;
	}

	public void setFieldDatatype(String fieldDatatype) {
		this.fieldDatatype = fieldDatatype;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public FieldsData(Integer issueID, String fieldName, String fieldValue, String fieldDatatype, Date dt) {
		super();
		this.issueID = issueID;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.fieldDatatype = fieldDatatype;
		this.dt = dt;
	}

	public FieldsData() {
	}

}
