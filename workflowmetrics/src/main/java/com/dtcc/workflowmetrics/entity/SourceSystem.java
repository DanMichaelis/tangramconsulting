
package com.dtcc.workflowmetrics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sourceSystem")

@Table(name = "SourceSystem")
public class SourceSystem {

	@Id
	private Integer id;

	@Column
	private String description;

	public SourceSystem() {
	}

	public SourceSystem(int id, String description) {
		this.id = Integer.valueOf(id);
		this.description = description;
	}

	public final Integer getId() {
		return id;
	}

	public final SourceSystem setId(Integer id) {
		this.id = id;

		return this;
	}

	public final String getDescription() {
		return description;
	}

	public final SourceSystem setDescription(String description) {
		this.description = description;

		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SourceSystem other = (SourceSystem) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SourceSystem [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}
