package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "status")
@Table(name = "Status")
@IdClass(StatusId.class)
public class Status implements Serializable {

	@Id
	private String statusId;

	@Id
	@Column(name = "SourceSystemId")
	private int sourceSystemId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "LastUpdateDate")
	private Long lastUpdateDate;

	@Column(name = "CheckSum", length = 5000)
	private String checkSum;

	private ArrayList<StatusCustomField> statusCustomField;

	private ArrayList<StatusTValue> statusTValue;

	public final String getStatusId() {
		return statusId;
	}

	public final Status setStatusId(String statusId) {
		this.statusId = statusId;
		return this;
	}

	public final int getSourceSystemId() {
		return sourceSystemId;
	}

	public final Status setSourceSystemId(int sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final Status setName(String name) {
		this.name = name;
		return this;
	}

	public final String getDescription() {
		return description;
	}

	public final Status setDescription(String description) {
		this.description = description;
		return this;
	}

	public final Long getLastUpdateDate() {
		return lastUpdateDate;
	}

	public final Status setLastUpdateDate(Long lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
		return this;
	}

	public final String getCheckSum() {
		return checkSum;
	}

	public final Status setCheckSum(String checkSum) {
		this.checkSum = checkSum;
		return this;
	}

	public final ArrayList<StatusCustomField> getStatusCustomField() {
		return statusCustomField;
	}

	public final Status setStatusCustomField(ArrayList<StatusCustomField> statusCustomField) {
		this.statusCustomField = statusCustomField;
		return this;
	}

	public final ArrayList<StatusTValue> getStatusTValue() {
		return statusTValue;
	}

	public final Status setStatusTValue(ArrayList<StatusTValue> statusTValue) {
		this.statusTValue = statusTValue;
		return this;
	}

	public Status(String statusId, int sourceSystemId, String name, String description, Long lastUpdateDate,
			String checkSum, ArrayList<StatusCustomField> statusCustomField, ArrayList<StatusTValue> statusTValue) {
		super();
		this.statusId = statusId;
		this.sourceSystemId = sourceSystemId;
		this.name = name;
		this.description = description;
		this.lastUpdateDate = lastUpdateDate;
		this.checkSum = calculateChecksum();
		this.statusCustomField = statusCustomField;
		this.statusTValue = statusTValue;
	}

	public Status(String statusId, int sourceSystemId, String name, String description, Long lastUpdateDate,
			ArrayList<StatusCustomField> statusCustomField, ArrayList<StatusTValue> statusTValue) {
		super();
		this.statusId = statusId;
		this.sourceSystemId = sourceSystemId;
		this.name = name;
		this.description = description;
		this.lastUpdateDate = lastUpdateDate;
		this.checkSum = calculateChecksum();
		this.statusCustomField = statusCustomField;
		this.statusTValue = statusTValue;
	}

	public Status(Status s) {
		super();
		this.statusId = s.statusId;
		this.sourceSystemId = s.sourceSystemId;
		this.name = s.name;
		this.description = s.description;
		this.lastUpdateDate = s.lastUpdateDate;
		this.checkSum = s.checkSum;
		statusCustomField = new ArrayList<StatusCustomField>();
		for (StatusCustomField cf : s.getStatusCustomField()) {
			statusCustomField.add(cf.clone());
		}

		statusTValue = new ArrayList<StatusTValue>();
		for (StatusTValue tv : s.getStatusTValue()) {
			statusTValue.add(tv.clone());
		}

	}

	public Status() {
		super();
	}

	public ArrayList<StatusCustomField> addCustomField(StatusCustomField field) {

		if (null == statusCustomField) {
			statusCustomField = new ArrayList<StatusCustomField>();
		}

		if (null != field) {
			if (!(field.getStatusId().equals(this.getStatusId()))) {
				throw new RuntimeException("StatusId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (StatusCustomField s : statusCustomField) {
					if (s.getFieldName().equals(field.getFieldName())) {
						fieldPresent = true;
						s.setFieldValue(field.getFieldValue());
					}
				}

				if (!fieldPresent) {
					statusCustomField.add(field);
				}
			}
		}

		return statusCustomField;
	}

	public ArrayList<StatusTValue> addStatusTValue(StatusTValue value) {

		if (null == statusTValue) {
			statusTValue = new ArrayList<StatusTValue>();
		}

		if (null != value) {
			if (!(value.getStatusId().equals(this.getStatusId()))) {
				throw new RuntimeException("StatusId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (StatusTValue s : statusTValue) {
					if (s.getTValue() == value.getTValue()) {
						fieldPresent = true;
						s.setTValue(value.getTValue());
					}
				}

				if (!fieldPresent) {
					statusTValue.add(value);
				}
			}
		}

		return statusTValue;
	}

	public Status clone() {
		Status clone = new Status();
		clone.setStatusId(this.statusId);
		clone.setSourceSystemId(this.sourceSystemId);
		clone.setName(this.name);
		clone.setDescription(this.description);
		clone.setLastUpdateDate(this.lastUpdateDate);
		clone.setCheckSum(this.checkSum);

		ArrayList<StatusCustomField> arr = new ArrayList<StatusCustomField>();

		for (StatusCustomField s : this.statusCustomField) {

			arr.add(new StatusCustomField(s));

		}

		clone.setStatusCustomField(arr);

		ArrayList<StatusTValue> val = new ArrayList<StatusTValue>();

		for (StatusTValue v : this.statusTValue) {

			val.add(new StatusTValue(v));

		}

		clone.setStatusTValue(val);

		return clone;
	}

	private String calculateChecksum() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toStringWithoutCustomFieldsAndLastUpdateDate());

		if (statusCustomField != null) {
			for (StatusCustomField f : statusCustomField) {
				sb.append(f.toStringWithoutCreateDate());
			}
		}
		if (statusTValue != null) {
			for (StatusTValue v : statusTValue) {
				sb.append(v.toStringWithoutCreateDate());
			}
		}
		return ChecksumUtil.getChecksum(sb.toString());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Status [statusId=");
		builder.append(statusId);
		builder.append(", SourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", lastUpdateDate=");
		builder.append(lastUpdateDate);
		builder.append(", statusCustomField=");
		builder.append(statusCustomField);
		builder.append(", statusTValue=");
		builder.append(statusTValue);
		builder.append(", checkSum=");
		builder.append(checkSum);
		builder.append("]");
		return builder.toString();
	}

	public String toStringWithoutCustomFieldsAndLastUpdateDate() {
		StringBuilder builder = new StringBuilder();
		builder.append("Status [statusId=");
		builder.append(statusId);
		builder.append(", SourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", checkSum=");
		builder.append(checkSum);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkSum == null) ? 0 : checkSum.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sourceSystemId;
		result = prime * result + ((statusCustomField == null) ? 0 : statusCustomField.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((statusTValue == null) ? 0 : statusTValue.hashCode());
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
		Status other = (Status) obj;
		if (checkSum == null) {
			if (other.checkSum != null)
				return false;
		} else if (!checkSum.equals(other.checkSum))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sourceSystemId != other.sourceSystemId)
			return false;
		if (statusCustomField == null) {
			if (other.statusCustomField != null)
				return false;
		} else if (!statusCustomField.equals(other.statusCustomField))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (statusTValue == null) {
			if (other.statusTValue != null)
				return false;
		} else if (!statusTValue.equals(other.statusTValue))
			return false;
		return true;
	}

}
