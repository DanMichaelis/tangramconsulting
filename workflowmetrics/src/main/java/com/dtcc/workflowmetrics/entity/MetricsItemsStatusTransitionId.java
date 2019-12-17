package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class MetricsItemsStatusTransitionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemId;

	private String projectId;

	private int sourceSystemId;

	private int fromStatus;

	private int toStatus;

	public MetricsItemsStatusTransitionId(String itemId, String projectId, int sourceSystemId, int fromStatus,
			int toStatus) {
		super();
		this.itemId = itemId;
		this.projectId = projectId;
		this.sourceSystemId = sourceSystemId;
		this.fromStatus = fromStatus;
		this.toStatus = toStatus;
	}

	public MetricsItemsStatusTransitionId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fromStatus;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + sourceSystemId;
		result = prime * result + toStatus;
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
		MetricsItemsStatusTransitionId other = (MetricsItemsStatusTransitionId) obj;
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
		return true;
	}

	
}
