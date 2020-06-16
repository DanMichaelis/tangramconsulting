package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class ProjectCustomFieldId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String projectId;
	
	private int sourceSystem;
	
	private Long createDate;
	
	private String fieldName;

	public ProjectCustomFieldId(String projectId, int sourceSystem, Long createDate, String fieldName) {
		super();
		this.projectId = projectId;
		this.sourceSystem = sourceSystem;
		this.createDate = createDate;
		this.fieldName = fieldName;
	}

	
	public ProjectCustomFieldId() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + sourceSystem;
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
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
		ProjectCustomFieldId other = (ProjectCustomFieldId) obj;
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
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

}
