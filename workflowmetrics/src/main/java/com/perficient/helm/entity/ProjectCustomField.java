package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "projectCustomField")
@Table(name = "ProjectCustomField")
@IdClass(ProjectCustomFieldId.class)
public class ProjectCustomField implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ProjectId")
	private String projectId;

	@Id
	@Column(name = "SourceSystem")
	private int sourceSystem;

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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(int sourceSystem) {
		this.sourceSystem = sourceSystem;
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

	public ProjectCustomField(String projectId, int sourceSystem, Long createDate, String fieldName,
			String fieldDatatype, String fieldValue) {
		super();
		this.projectId = projectId;
		this.sourceSystem = sourceSystem;
		this.createDate = createDate;
		this.fieldName = fieldName;
		this.fieldDatatype = fieldDatatype;
		this.fieldValue = fieldValue;
	}

	public ProjectCustomField() {
		super();
	}

	private ProjectCustomField(ProjectCustomField cf) {
        this.createDate = cf.getCreateDate();
        this.fieldDatatype = cf.getFieldDatatype();
        this.fieldName = cf.getFieldName();
        this.fieldValue = cf.getFieldValue();
        this.projectId = cf.getProjectId();
        this.sourceSystem = cf.getSourceSystem();
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((fieldDatatype == null) ? 0 : fieldDatatype.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((fieldValue == null) ? 0 : fieldValue.hashCode());
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
		ProjectCustomField other = (ProjectCustomField) obj;
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
		if (sourceSystem != other.sourceSystem)
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}
	
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProjectCustomField [projectId=");
        builder.append(projectId);
        builder.append(", sourceSystem=");
        builder.append(sourceSystem);
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

    public String toStringWithoutCreateDate() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProjectCustomField [projectId=");
        builder.append(projectId);
        builder.append(", sourceSystem=");
        builder.append(sourceSystem);
        builder.append(", fieldName=");
        builder.append(fieldName);
        builder.append(", fieldDatatype=");
        builder.append(fieldDatatype);
        builder.append(", fieldValue=");
        builder.append(fieldValue);
        builder.append("]");
        return builder.toString();
    }
    
    public ProjectCustomField clone() {
        return new ProjectCustomField(this);
    }
}
