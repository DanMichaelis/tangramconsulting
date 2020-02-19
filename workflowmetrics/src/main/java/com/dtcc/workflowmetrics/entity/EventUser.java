package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "eventUser")
@Table(name = "EventUser")
@IdClass(EventUserId.class)
public class EventUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Id
	@Column(name = "SourceSystem")
	private int sourceSystem;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "EmailId")
	private String emailId;

	@Column(name = "LastUpdateDate")
	private Long lastUpdateDate;

	@Column(name = "CheckSum", length = 5000)
	private String checkSum;

	private ArrayList<EventUserCustomField> eventUserCustomField;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(int sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Long lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public ArrayList<EventUserCustomField> getEventUserCustomField() {
		return eventUserCustomField;
	}

	public void setEventUserCustomField(ArrayList<EventUserCustomField> eventUserCustomField) {
		this.eventUserCustomField = eventUserCustomField;
	}

	private EventUser(EventUser e) {
		this.id = e.getId();
		this.sourceSystem = e.getSourceSystem();
		this.userName = e.getUserName();
		this.emailId = e.getEmailId();
		this.lastUpdateDate = e.getLastUpdateDate();
		eventUserCustomField = new ArrayList<EventUserCustomField>();
		for (EventUserCustomField cf : e.getEventUserCustomField()) {
			eventUserCustomField.add(cf.clone());
		}
	}

	public EventUser(String id, int sourceSystem, String userName, String emailId, Long lastUpdateDate,
			ArrayList<EventUserCustomField> eventUserCustomField, String checkSum) {
		super();
		this.id = id;
		this.sourceSystem = sourceSystem;
		this.userName = userName;
		this.emailId = emailId;
		this.lastUpdateDate = lastUpdateDate;
		this.eventUserCustomField = eventUserCustomField;
		this.checkSum = calculateChecksum();
	}

	public EventUser(String id, int sourceSystem, String userName, String emailId, Long lastUpdateDate,
			ArrayList<EventUserCustomField> eventUserCustomField) {
		super();
		this.id = id;
		this.sourceSystem = sourceSystem;
		this.userName = userName;
		this.emailId = emailId;
		this.lastUpdateDate = lastUpdateDate;
		this.eventUserCustomField = eventUserCustomField;
		this.checkSum = calculateChecksum();
	}

	public EventUser() {
	}

	public ArrayList<EventUserCustomField> addCustomField(EventUserCustomField field) {

		if (null == eventUserCustomField) {
			eventUserCustomField = new ArrayList<EventUserCustomField>();
		}

		if (null != field) {
			if (!(field.getUserID().equals(this.getId()))) {
				throw new RuntimeException("FieldUserId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (EventUserCustomField f : eventUserCustomField) {
					if (f.getFieldName().equals(field.getFieldName())) {
						fieldPresent = true;
						f.setFieldValue(field.getFieldValue());
					}
				}

				if (!fieldPresent) {
					eventUserCustomField.add(field);
				}
			}
		}

		return eventUserCustomField;
	}

	public EventUser clone() {
		EventUser clone = new EventUser();
		clone.setId(this.id);
		clone.setEmailId(this.emailId);
		clone.setCheckSum(this.checkSum);
		clone.setSourceSystem(this.sourceSystem);
		clone.setUserName(this.userName);
		clone.setLastUpdateDate(this.lastUpdateDate);

		ArrayList<EventUserCustomField> arr = new ArrayList<EventUserCustomField>();

		for (EventUserCustomField e : this.eventUserCustomField) {

			arr.add(new EventUserCustomField(e));

		}

		clone.setEventUserCustomField(arr);

		return clone;
	}

	private String calculateChecksum() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toStringWithoutCustomFieldsAndLastUpdateDate());

		for (EventUserCustomField f : eventUserCustomField) {
			sb.append(f.toStringWithoutCreateDate());
		}
		return ChecksumUtil.getChecksum(sb.toString());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventUser [id=");
		builder.append(id);
		builder.append(", SourceSystem=");
		builder.append(sourceSystem);
		builder.append(", UserName=");
		builder.append(userName);
		builder.append(", EmailId=");
		builder.append(emailId);
		builder.append(", LastUpdateDate=");
		builder.append(lastUpdateDate);
		builder.append(", EventUserCustomField=");
		builder.append(eventUserCustomField);
		builder.append(", CheckSum=");
		builder.append(checkSum);
		builder.append("]");
		return builder.toString();
	}


	public String toStringWithoutCustomFieldsAndLastUpdateDate() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventUser [id=");
		builder.append(id);
		builder.append(", SourceSystem=");
		builder.append(sourceSystem);
		builder.append(", UserName=");
		builder.append(userName);
		builder.append(", EmailId=");
		builder.append(emailId);
		builder.append(", CheckSum=");
		builder.append(checkSum);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkSum == null) ? 0 : checkSum.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((eventUserCustomField == null) ? 0 : eventUserCustomField.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + sourceSystem;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		EventUser other = (EventUser) obj;
		if (checkSum == null) {
			if (other.checkSum != null)
				return false;
		} else if (!checkSum.equals(other.checkSum))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (eventUserCustomField == null) {
			if (other.eventUserCustomField != null)
				return false;
		} else if (!eventUserCustomField.equals(other.eventUserCustomField))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (sourceSystem != other.sourceSystem)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
