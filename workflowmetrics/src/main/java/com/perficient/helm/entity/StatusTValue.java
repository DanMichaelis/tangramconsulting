package com.perficient.helm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "statusTValue")
@Table(name = "StatusTValue")
@IdClass(StatusTValueId.class)
public class StatusTValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "StatusID")
	private String statusId;

	@Id
	@Column(name = "SourceSystemId")
	private int sourceSystemId;

	@Column(name = "CreateDate")
	private Long createDate;

	@Id
	@Column(name = "TValue")
	private int tValue;

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

	public int getTValue() {
		return tValue;
	}

	public void setTValue(int tValue) {
		this.tValue = tValue;
	}

	public StatusTValue(String statusId, int sourceSystemId, Long createDate, int tValue) {
		super();
		this.statusId = statusId;
		this.sourceSystemId = sourceSystemId;
		this.createDate = createDate;
		this.tValue = tValue;
	}

	public StatusTValue(StatusTValue s) {
		super();
		this.statusId = s.statusId;
		this.sourceSystemId = s.sourceSystemId;
		this.createDate = s.createDate;
		this.tValue = s.tValue;
	}

	public StatusTValue() {
		super();
	}

	public StatusTValue clone() {
		return new StatusTValue(this);
	}

	public String toStringWithoutCreateDate() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusTValue [statusId=");
		builder.append(statusId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", tValue=");
		builder.append(tValue);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusTValue [statusId=");
		builder.append(statusId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", tValue=");
		builder.append(tValue);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tValue;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
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
		StatusTValue other = (StatusTValue) obj;
		if (tValue != other.tValue)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
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

}
