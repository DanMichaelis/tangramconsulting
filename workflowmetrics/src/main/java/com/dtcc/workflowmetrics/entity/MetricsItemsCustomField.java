package com.dtcc.workflowmetrics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "metricsItemsCustomField")
@Table(name = "MetricsItemsCustomField")
@IdClass(MetricsItemsCustomFieldId.class)
public class MetricsItemsCustomField {

	@Id
	@Column(name = "ItemId")
	private String itemId;

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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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


	public MetricsItemsCustomField(String itemId, int sourceSystemId, Long createDate, String fieldName,
			String fieldDatatype, String fieldValue) {
		super();
		this.itemId = itemId;
		this.sourceSystemId = sourceSystemId;
		this.createDate = createDate;
		this.fieldName = fieldName;
		this.fieldDatatype = fieldDatatype;
		this.fieldValue = fieldValue;
	}

	
	public MetricsItemsCustomField() {
		super();
	}

	public MetricsItemsCustomField(MetricsItemsCustomField cf) {
		this.itemId = cf.itemId;
		this.sourceSystemId = cf.sourceSystemId;
		this.createDate = cf.createDate;
		this.fieldName = cf.fieldName;
		this.fieldDatatype = cf.fieldDatatype;
		this.fieldValue = cf.fieldValue;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((fieldDatatype == null) ? 0 : fieldDatatype.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((fieldValue == null) ? 0 : fieldValue.hashCode());
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
		MetricsItemsCustomField other = (MetricsItemsCustomField) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
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
		return true;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MetricsItemsCustomField [itemId=");
        builder.append(itemId);
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

    public String toStringWithoutCreateDate() {
        StringBuilder builder = new StringBuilder();
        builder.append("MetricsItemsCustomField [itemId=");
        builder.append(itemId);
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

    public MetricsItemsCustomField clone() {
        return new MetricsItemsCustomField(this);
    }

}
