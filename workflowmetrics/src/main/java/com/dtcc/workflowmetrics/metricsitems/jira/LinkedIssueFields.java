package com.dtcc.workflowmetrics.metricsitems.jira;

import com.dtcc.workflowmetrics.metricsitems.jira.common.Priority;
import com.dtcc.workflowmetrics.metricsitems.jira.common.StatusDetails;

public class LinkedIssueFields {
    private String summary;
    private String description;
    private StatusDetails status;
    private Priority priority;
    private IssueType issuetype;
    public String getSummary() {
        return summary;
    }
    public LinkedIssueFields setSummary(String summary) {
        this.summary = summary;
    
        return this;
    }
    public String getDescription() {
        return description;
    }
    public LinkedIssueFields setDescription(String description) {
        this.description = description;
    
        return this;
    }
    public StatusDetails getStatus() {
        return status;
    }
    public LinkedIssueFields setStatus(StatusDetails status) {
        this.status = status;
    
        return this;
    }
    public Priority getPriority() {
        return priority;
    }
    public LinkedIssueFields setPriority(Priority priority) {
        this.priority = priority;
    
        return this;
    }
    public IssueType getIssuetype() {
        return issuetype;
    }
    public LinkedIssueFields setIssuetype(IssueType issuetype) {
        this.issuetype = issuetype;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((issuetype == null) ? 0 : issuetype.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
        LinkedIssueFields other = (LinkedIssueFields) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (issuetype == null) {
            if (other.issuetype != null) {
                return false;
            }
        } else if (!issuetype.equals(other.issuetype)) {
            return false;
        }
        if (priority == null) {
            if (other.priority != null) {
                return false;
            }
        } else if (!priority.equals(other.priority)) {
            return false;
        }
        if (status == null) {
            if (other.status != null) {
                return false;
            }
        } else if (!status.equals(other.status)) {
            return false;
        }
        if (summary == null) {
            if (other.summary != null) {
                return false;
            }
        } else if (!summary.equals(other.summary)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedIssueFields [summary=");
        builder.append(summary);
        builder.append(", description=");
        builder.append(description);
        builder.append(", status=");
        builder.append(status);
        builder.append(", priority=");
        builder.append(priority);
        builder.append(", issuetype=");
        builder.append(issuetype);
        builder.append("]");
        return builder.toString();
    }
}
