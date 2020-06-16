package com.perficient.helm.entity;

import java.io.Serializable;

public class StatusTValueId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusId;

	private int sourceSystemId;

	public StatusTValueId(String statusId, int sourceSystemId) {
		super();
		this.statusId = statusId;
		this.sourceSystemId = sourceSystemId;
	}

	public StatusTValueId() {
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
		StatusTValueId other = (StatusTValueId) obj;
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
