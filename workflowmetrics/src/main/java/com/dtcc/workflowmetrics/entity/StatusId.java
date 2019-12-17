package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class StatusId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusId;

	private int sourceSystemId;

	public StatusId(String statusId, int sourceSystemId) {
		super();
		this.statusId = statusId;
		this.sourceSystemId = sourceSystemId;
	}

	public StatusId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		StatusId other = (StatusId) obj;
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
