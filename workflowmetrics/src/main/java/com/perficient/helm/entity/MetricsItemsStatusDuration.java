package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "metricsItemsStatusDuration")
@Table(name = "MetricsItemsStatusDuration")
@IdClass(MetricsItemsStatusDurationId.class)
public class MetricsItemsStatusDuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ItemId")
	private String itemId;

	
	@Column(name = "ProjectId")
	private String projectId;

	
	@Column(name = "SourceSystemId")
	private int sourceSystemId;

	@Id
	@Column(name = "Status")
	private String status;

	@Column(name = "Duration")
	private Long duration;

	@Id
	@Column(name = "StartDate")
	private Long startDate;
	
	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(int sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MetricsItemsStatusDuration(String itemId, String projectId, int sourceSystemId, String status, Long duration, Long startDate) {
		super();
		this.itemId = itemId;
		this.projectId = projectId;
		this.sourceSystemId = sourceSystemId;
		this.status = status;
		this.duration = duration;
		this.startDate = startDate;
	}

	public MetricsItemsStatusDuration() {
		super();
	}
	
	public MetricsItemsStatusDuration(MetricsItemsStatusDuration sd) {
		super();
		this.itemId = sd.itemId;
		this.projectId = sd.projectId;
		this.sourceSystemId = sd.sourceSystemId;
		this.status = sd.status;
		this.duration = sd.duration;
		this.startDate = sd.startDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + sourceSystemId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		MetricsItemsStatusDuration other = (MetricsItemsStatusDuration) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (sourceSystemId != other.sourceSystemId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	   @Override
	    public String toString() {
	        StringBuilder builder = new StringBuilder();
	        builder.append("MetricsItemsStatusDuration [itemId=");
	        builder.append(itemId);
	        builder.append(", ProjectId=");
	        builder.append(projectId);
	        builder.append(", sourceSystemId=");
	        builder.append(sourceSystemId);
	        builder.append(", status=");
	        builder.append(status);
	        builder.append(", duration=");
	        builder.append(duration);
	        builder.append(", startDate=");
	        builder.append(startDate);
	        return builder.toString();
	    }

	    public String toStringWithoutDuration() {
	        StringBuilder builder = new StringBuilder();
	        builder.append("MetricsItemsStatusDuration [itemId=");
	        builder.append(itemId);
	        builder.append(", ProjectId=");
	        builder.append(projectId);
	        builder.append(", sourceSystemId=");
	        builder.append(sourceSystemId);
	        builder.append(", status=");
	        builder.append(status);
	        return builder.toString();
	    }

	    public MetricsItemsStatusDuration clone() {
	        return new MetricsItemsStatusDuration(this);
	    }

}
