package com.perficient.helm.entity;

import java.io.Serializable;

public class MetricsItemsStatusTransitionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemId;

	private Long transitionDate;

	public MetricsItemsStatusTransitionId(String itemId, Long transitionDate) {
		super();
		this.itemId = itemId;
		this.transitionDate = transitionDate;
	}

	public MetricsItemsStatusTransitionId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		MetricsItemsStatusTransitionId other = (MetricsItemsStatusTransitionId) obj;
		if (transitionDate == null) {
			if (other.transitionDate != null)
				return false;
		} else if (!transitionDate.equals(other.transitionDate))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		
		return true;
	}

	
}
