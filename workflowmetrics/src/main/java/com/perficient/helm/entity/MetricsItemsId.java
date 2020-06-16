package com.perficient.helm.entity;

import java.io.Serializable;

public class MetricsItemsId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemKey;

	private int sourceSystemId;

	public MetricsItemsId(String itemKey, int sourceSystemId) {
		super();
		this.itemKey = itemKey;
		this.sourceSystemId = sourceSystemId;
	}

	public MetricsItemsId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemKey == null) ? 0 : itemKey.hashCode());
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
		if (itemKey == null) {
			if (other.itemKey != null)
				return false;
		} else if (!itemKey.equals(other.itemKey))
			return false;
		if (sourceSystemId != other.sourceSystemId)
			return false;
		return true;
	}

	
}
