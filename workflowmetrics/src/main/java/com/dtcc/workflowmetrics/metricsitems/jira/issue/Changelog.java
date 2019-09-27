package com.dtcc.workflowmetrics.metricsitems.jira.issue;

import java.util.ArrayList;

public class Changelog {
    private Integer startAt;
    private Integer maxResults;
    private Integer total;
    private ArrayList<History> histories;
    public Integer getStartAt() {
        return startAt;
    }
    public Changelog setStartAt(Integer startAt) {
        this.startAt = startAt;
    
        return this;
    }
    public Integer getMaxResults() {
        return maxResults;
    }
    public Changelog setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    
        return this;
    }
    public Integer getTotal() {
        return total;
    }
    public Changelog setTotal(Integer total) {
        this.total = total;
    
        return this;
    }
    public ArrayList<History> getHistories() {
        return histories;
    }
    public Changelog setHistories(ArrayList<History> histories) {
        this.histories = histories;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((histories == null) ? 0 : histories.hashCode());
        result = prime * result + ((maxResults == null) ? 0 : maxResults.hashCode());
        result = prime * result + ((startAt == null) ? 0 : startAt.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
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
        Changelog other = (Changelog) obj;
        if (histories == null) {
            if (other.histories != null) {
                return false;
            }
        } else if (!histories.equals(other.histories)) {
            return false;
        }
        if (maxResults == null) {
            if (other.maxResults != null) {
                return false;
            }
        } else if (!maxResults.equals(other.maxResults)) {
            return false;
        }
        if (startAt == null) {
            if (other.startAt != null) {
                return false;
            }
        } else if (!startAt.equals(other.startAt)) {
            return false;
        }
        if (total == null) {
            if (other.total != null) {
                return false;
            }
        } else if (!total.equals(other.total)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Changelog [startAt=");
        builder.append(startAt);
        builder.append(", maxResults=");
        builder.append(maxResults);
        builder.append(", total=");
        builder.append(total);
        builder.append(", histories=[");
        for (History history : histories) {
            if (!builder.substring(builder.length() - 1).equals("[")) {
                builder.append(", ");
            }
            builder.append(history.toString());
        }
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
