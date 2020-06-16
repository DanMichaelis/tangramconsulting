package com.perficient.helm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "statusCustomField")
@Table(name = "StatusCustomField")
@IdClass(StatusCustomFieldId.class)
public class StatusCustomField implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "StatusId")
	private String statusId;

	@Id
	@Column(name = "SourceSystemId")
	private int sourceSystemId;

	@Id
	@Column(name = "CreateDate")
	private Long createDate;

	@Id
	@Column(name = "FieldName")
	private String fieldName;

	@Column(name = "FieldDatatype")
	private String fieldDatatype;

	@Column(name = "FieldValue")
	private String fieldValue;

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public int getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(int sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDatatype() {
		return fieldDatatype;
	}

	public void setFieldDatatype(String fieldDatatype) {
		this.fieldDatatype = fieldDatatype;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public StatusCustomField(String statusId, int sourceSystemId, Long createDate, String fieldName,
			String fieldDatatype, String fieldValue) {
		super();
		this.statusId = statusId;
		this.sourceSystemId = sourceSystemId;
		this.createDate = createDate;
		this.fieldName = fieldName;
		this.fieldDatatype = fieldDatatype;
		this.fieldValue = fieldValue;
	}

	public StatusCustomField() {
		super();
	}

	public StatusCustomField(StatusCustomField s) {
		super();
		this.statusId = s.statusId;
		this.sourceSystemId = s.sourceSystemId;
		this.createDate = s.createDate;
		this.fieldName = s.fieldName;
		this.fieldDatatype = s.fieldDatatype;
		this.fieldValue = s.fieldValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((fieldDatatype == null) ? 0 : fieldDatatype.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((fieldValue == null) ? 0 : fieldValue.hashCode());
		result = prime * result + sourceSystemId;
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusCustomField other = (StatusCustomField) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (fieldDatatype == null) {
			if (other.fieldDatatype != null)
				return false;
		} else if (!fieldDatatype.equals(other.fieldDatatype))
			return false;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (fieldValue == null) {
			if (other.fieldValue != null)
				return false;
		} else if (!fieldValue.equals(other.fieldValue))
			return false;
		if (sourceSystemId != other.sourceSystemId)
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		return true;
	}

	public StatusCustomField clone() {
		return new StatusCustomField(this);
	}

	public String toStringWithoutCreateDate() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusCustomField [StatusId=");
		builder.append(statusId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", fieldName=");
		builder.append(fieldName);
		builder.append(", fieldDatatype=");
		builder.append(fieldDatatype);
		builder.append(", fieldValue=");
		builder.append(fieldValue);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusCustomField [StatusId=");
		builder.append(statusId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", fieldName=");
		builder.append(fieldName);
		builder.append(", fieldDatatype=");
		builder.append(fieldDatatype);
		builder.append(", fieldValue=");
		builder.append(fieldValue);
		builder.append("]");
		return builder.toString();
	}

}
