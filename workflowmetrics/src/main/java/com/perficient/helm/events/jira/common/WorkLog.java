package com.perficient.helm.events.jira.common;

import java.util.ArrayList;

public class WorkLog {

	private String startAt;
	private String maxResults;
	private String total;
	private ArrayList<Object> worklogs;
	
	public String getStartAt() {
		return startAt;
	}
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	public String getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(String maxResults) {
		this.maxResults = maxResults;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public ArrayList<Object> getWorklogs() {
		return worklogs;
	}
	public void setWorklogs(ArrayList<Object> worklogs) {
		this.worklogs = worklogs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxResults == null) ? 0 : maxResults.hashCode());
		result = prime * result + ((startAt == null) ? 0 : startAt.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((worklogs == null) ? 0 : worklogs.hashCode());
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
		WorkLog other = (WorkLog) obj;
		if (maxResults == null) {
			if (other.maxResults != null)
				return false;
		} else if (!maxResults.equals(other.maxResults))
			return false;
		if (startAt == null) {
			if (other.startAt != null)
				return false;
		} else if (!startAt.equals(other.startAt))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (worklogs == null) {
			if (other.worklogs != null)
				return false;
		} else if (!worklogs.equals(other.worklogs))
			return false;
		return true;
	}
	@Override
	public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WorkLog [startAt=");
        builder.append(startAt);
        builder.append(", maxResults=");
        builder.append(maxResults);
        builder.append(", total=");
        builder.append(total);
        builder.append(", worklogs=");
        builder.append(worklogs);
        builder.append("]");
        return builder.toString();
    }
	
	
}
