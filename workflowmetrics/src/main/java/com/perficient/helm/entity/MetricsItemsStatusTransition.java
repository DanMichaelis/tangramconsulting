package com.perficient.helm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "metricsItemsStatusTransition")
@Table(name = "MetricsItemsStatusTransition")
@IdClass(MetricsItemsStatusTransitionId.class)
public class MetricsItemsStatusTransition implements Serializable {

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

	
	@Column(name = "FromStatus")
	private String fromStatus;

	
	@Column(name = "ToStatus")
	private String toStatus;

	@Id
	@Column(name = "TransitionDate")
	private Long transitionDate;

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

	public String getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	public String getToStatus() {
		return toStatus;
	}

	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	public Long getTransitionDate() {
		return transitionDate;
	}

	public void setTransitionDate(Long transitionDate) {
		this.transitionDate = transitionDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MetricsItemsStatusTransition(String itemId, String projectId, int sourceSystemId, String fromStatus,
			String toStatus, Long transitionDate) {
		super();
		this.itemId = itemId;
		this.projectId = projectId;
		this.sourceSystemId = sourceSystemId;
		this.fromStatus = fromStatus;
		this.toStatus = toStatus;
		this.transitionDate = transitionDate;
	}

	public MetricsItemsStatusTransition() {
		super();
	}

	public MetricsItemsStatusTransition(MetricsItemsStatusTransition st) {
		super();
		this.itemId = st.itemId;
		this.projectId = st.projectId;
		this.sourceSystemId = st.sourceSystemId;
		this.fromStatus = st.fromStatus;
		this.toStatus = st.toStatus;
		this.transitionDate = st.transitionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromStatus == null) ? 0 : fromStatus.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + sourceSystemId;
		result = prime * result + ((toStatus == null) ? 0 : toStatus.hashCode());
		result = prime * result + ((transitionDate == null) ? 0 : transitionDate.hashCode());
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
		MetricsItemsStatusTransition other = (MetricsItemsStatusTransition) obj;
		if (fromStatus != other.fromStatus)
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
		if (toStatus != other.toStatus)
			return false;
		if (transitionDate == null) {
			if (other.transitionDate != null)
				return false;
		} else if (!transitionDate.equals(other.transitionDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetricsItemsTStatusTransition [itemId=");
		builder.append(itemId);
		builder.append(", ProjectId=");
		builder.append(projectId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", fromStatus=");
		builder.append(fromStatus);
		builder.append(", toStatus=");
		builder.append(toStatus);
		builder.append(", transitionDate=");
		builder.append(transitionDate);
		return builder.toString();
	}

	public String toStringWithoutDate() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetricsItemsTStatusTransition [itemId=");
		builder.append(itemId);
		builder.append(", ProjectId=");
		builder.append(projectId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", fromStatus=");
		builder.append(fromStatus);
		builder.append(", toStatus=");
		builder.append(toStatus);
		return builder.toString();
	}

	public MetricsItemsStatusTransition clone() {
		return new MetricsItemsStatusTransition(this);
	}

}
