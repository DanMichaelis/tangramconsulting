package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class MetricsItemsTStatusDurationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemId;

	private String projectId;

	private int sourceSystemId;

	private int status;

	public MetricsItemsTStatusDurationId(String itemId, String projectId, int sourceSystemId, int status) {
		super();
		this.itemId = itemId;
		this.projectId = projectId;
		this.sourceSystemId = sourceSystemId;
		this.status = status;
	}

	public MetricsItemsTStatusDurationId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + sourceSystemId;
		result = prime * result + status;
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
		MetricsItemsTStatusDurationId other = (MetricsItemsTStatusDurationId) obj;
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
		return true;
	}

	
}
