package com.dtcc.workflowmetrics.issueObjects;

import java.util.Date;

public class IssueHistoryId {
    private String key;
    private Date eventDate;
    
    public IssueHistoryId (String key, Date eventDate) {
        this.key = key;
        this.eventDate = eventDate;
    }

    public IssueHistoryId() {
        // TODO Auto-generated constructor stub
    }

    public String getKey() {
        return key;
    }

    public IssueHistoryId setKey(String key) {
        this.key = key;
    
        return this;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public IssueHistoryId setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
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
        IssueHistoryId other = (IssueHistoryId) obj;
        if (eventDate == null) {
            if (other.eventDate != null)
                return false;
        } else if (!eventDate.equals(other.eventDate))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IssueHistoryId [key=" + key + ", eventDate=" + eventDate + "]";
    }
}
