package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

public class MetricsItemsId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemId;

	private int sourceSystemId;

	public MetricsItemsId(String itemId, int sourceSystemId) {
		super();
		this.itemId = itemId;
		this.sourceSystemId = sourceSystemId;
	}

	public MetricsItemsId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + sourceSystemId;
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
		MetricsItemsId other = (MetricsItemsId) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (sourceSystemId != other.sourceSystemId)
			return false;
		return true;
	}

	
}
