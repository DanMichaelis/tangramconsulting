package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class StatusCustomFieldId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusId;

	private int sourceSystemId;

	private Long createDate;

	private String fieldName;

	public StatusCustomFieldId(String statusID, int sourceSystemId, Long createDate, String fieldName) {
		super();
		this.statusId = statusID;
		this.sourceSystemId = sourceSystemId;
		this.createDate = createDate;
		this.fieldName = fieldName;
	}

	public StatusCustomFieldId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
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
		StatusCustomFieldId other = (StatusCustomFieldId) obj;
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
