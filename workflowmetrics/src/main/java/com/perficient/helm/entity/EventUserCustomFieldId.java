
package com.perficient.helm.entity;

import java.io.Serializable;

public class EventUserCustomFieldId implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String userID;

	private int sourceSystem;

	private Long createDate;

	private String fieldName;

	public EventUserCustomFieldId(String userID, int sourceSystem, Long createDate, String fieldName) {
		super();
		this.userID = userID;
		this.sourceSystem = sourceSystem;
		this.createDate = createDate;
		this.fieldName = fieldName;
	}

	public EventUserCustomFieldId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + sourceSystem;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		EventUserCustomFieldId other = (EventUserCustomFieldId) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (sourceSystem != other.sourceSystem)
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

}
