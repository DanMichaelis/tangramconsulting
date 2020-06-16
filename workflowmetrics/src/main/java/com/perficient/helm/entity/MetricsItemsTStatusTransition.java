package com.perficient.helm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "metricsItemsTStatusTransition")
@Table(name = "MetricsItemsTStatusTransition")
@IdClass(MetricsItemsTStatusTransitionId.class)
public class MetricsItemsTStatusTransition implements Serializable {

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

	@Column(name = "Status")
	private int status;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public MetricsItemsTStatusTransition(String itemId, String projectId, int sourceSystemId, int status,
			Long transitionDate) {
		super();
		this.itemId = itemId;
		this.projectId = projectId;
		this.sourceSystemId = sourceSystemId;
		this.status = status;
		this.transitionDate = transitionDate;
	}

	public MetricsItemsTStatusTransition() {
		super();
	}

	public MetricsItemsTStatusTransition(MetricsItemsTStatusTransition st) {
		super();
		this.itemId = st.itemId;
		this.projectId = st.projectId;
		this.sourceSystemId = st.sourceSystemId;
		this.status = st.status;
		this.transitionDate = st.transitionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + sourceSystemId;
		result = prime * result + status;
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
		MetricsItemsTStatusTransition other = (MetricsItemsTStatusTransition) obj;
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
		if (status != other.status)
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
		builder.append(", status=");
		builder.append(status);
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
		builder.append(", status=");
		builder.append(status);
		return builder.toString();
	}

	public MetricsItemsTStatusTransition clone() {
		return new MetricsItemsTStatusTransition(this);
	}

}
