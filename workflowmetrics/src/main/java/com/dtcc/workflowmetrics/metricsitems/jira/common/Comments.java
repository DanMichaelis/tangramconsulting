package com.dtcc.workflowmetrics.metricsitems.jira.common;

import java.util.ArrayList;

public class Comments {
    private ArrayList<Comment> comments;
    private Integer maxResults;
    private Integer total;
    private Integer startAt;
    public ArrayList<Comment> getComments() {
        return comments;
    }
    public Comments setComments(ArrayList<Comment> comments) {
        System.out.println("Setting comments");
        this.comments = comments;
    
        return this;
    }
    public Integer getMaxResults() {
        return maxResults;
    }
    public Comments setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    
        return this;
    }
    public Integer getTotal() {
        return total;
    }
    public Comments setTotal(Integer total) {
        this.total = total;
    
        return this;
    }
    public Integer getStartAt() {
        return startAt;
    }
    public Comments setStartAt(Integer startAt) {
        this.startAt = startAt;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comments == null) ? 0 : comments.hashCode());
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
        Comments other = (Comments) obj;
        if (comments == null) {
            if (other.comments != null) {
                return false;
            }
        } else if (!comments.equals(other.comments)) {
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
        builder.append("Comments [comments=");
        builder.append(comments);
        builder.append(", maxResults=");
        builder.append(maxResults);
        builder.append(", total=");
        builder.append(total);
        builder.append(", startAt=");
        builder.append(startAt);
        builder.append("]");
        return builder.toString();
    }
    
    
}
