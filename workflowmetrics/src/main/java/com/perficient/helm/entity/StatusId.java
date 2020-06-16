package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class StatusId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int sourceSystemId;

	private String name;

	public StatusId(int sourceSystemId, String name) {
		super();
		this.sourceSystemId = sourceSystemId;
		this.name = name;
	}

	public StatusId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sourceSystemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
