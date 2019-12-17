package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class EventUserId implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private String id;

	private int sourceSystem;

	public EventUserId(String id, int sourceSystem) {
		super();
		this.id = id;
		this.sourceSystem = sourceSystem;
	}

	public EventUserId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + sourceSystem;
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
		EventUserId other = (EventUserId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sourceSystem != other.sourceSystem)
			return false;
		return true;
	}

}
