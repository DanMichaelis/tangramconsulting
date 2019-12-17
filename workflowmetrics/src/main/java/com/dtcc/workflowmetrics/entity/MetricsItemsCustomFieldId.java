package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class MetricsItemsCustomFieldId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemId;

	private int sourceSystemId;

	private Long createDate;

	private String fieldName;

	public MetricsItemsCustomFieldId(String itemId, int sourceSystemId, Long createDate, String fieldName) {
		super();
		this.itemId = itemId;
		this.sourceSystemId = sourceSystemId;
		this.createDate = createDate;
		this.fieldName = fieldName;
	}

	public MetricsItemsCustomFieldId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + sourceSystemId;
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
		MetricsItemsCustomFieldId other = (MetricsItemsCustomFieldId) obj;
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
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (sourceSystemId != other.sourceSystemId)
			return false;
		return true;
	}
	
	

}
