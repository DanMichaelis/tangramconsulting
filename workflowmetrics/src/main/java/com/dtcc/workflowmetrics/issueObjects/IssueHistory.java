package com.dtcc.workflowmetrics.issueObjects;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.dtcc.workflowmetrics.issueObjects.util.IssueConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;

public class IssueHistory {

    
    private IssueHistoryId id;
    private String issueType;
    private String previousStatus;
    private String status;
    private String summary;
    private String description;
    private long durationInPreviousStatus;
    private static final ObjectMapper mapper = new ObjectMapper();

    public IssueHistory() {
        id = new IssueHistoryId();
    }

    public IssueHistory(String jiraUserStoryJSONString) {
        JsonNode node = null;
        id = new IssueHistoryId();

        try {
            node = mapper.readTree(jiraUserStoryJSONString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setPreviousStatus(node.at("/transition/from_status").asText());
        setStatus(node.at("/transition/to_status").asText());
        setEventDate(new Date(node.at("/timestamp").asLong()));
        setKey(node.at("/issue/key").asText());
        setIssueType(node.at("/issue/issuetype/fields/type").asText());
        setSummary(node.at("/issue/fields/summary").asText());
        setDescription(node.at("/issue/fields/description").asText());
    }

    public String getSummary() {
        return summary;
    }

    public IssueHistory setSummary(String title) {
        this.summary = title;

        return this;
    }

    public String getDescription() {
        return description;
    }

    public IssueHistory setDescription(String description) {
        this.description = description;

        return this;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public IssueHistory setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;

        return this;
    }

    public String getStatus() {
        return status;
    }

    public IssueHistory setStatus(String currentStatus) {
        this.status = currentStatus;

        return this;
    }


    public Date getEventDate() {
        return id.getEventDate();
    }

    public IssueHistory setEventDate(Date statusDateTime) {
        id.setEventDate(statusDateTime);

        return this;
    }

    public String getIssueType() {
        return issueType;
    }

    public IssueHistory setIssueType(String issueType) {
        this.issueType = issueType;

        return this;
    }

    public String getKey() {
        return id.getKey();
    }

    public IssueHistory setKey(String key) {
        id.setKey(key);

        return this;
    }
    
    public String toJiraJSONFormat() {
        return IssueConverter.toJson(this);
        
    }
    
    public long getDurationInPreviousStatus() {
        return durationInPreviousStatus;
    }

    public IssueHistory setDurationInPreviousStatus(IssueHistory previousIssueHistory) {
        this.durationInPreviousStatus = getEventDate().getTime() - previousIssueHistory.getEventDate().getTime();
    
        return this;
    }
    public IssueHistory setDurationInPreviousStatus(Date previousEventDate) {
        this.durationInPreviousStatus = getEventDate().getTime() - previousEventDate.getTime();
    
        return this;
    }

    @Override
    public String toString() {
        return "Issue [key=" + getKey() + ", previousStatus=" + previousStatus + ", currentStatus=" + status + ", statusDateTime="
                + getEventDate() + ", issueType=" + issueType + ", title=" + summary + ", description="
                + description + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((issueType == null) ? 0 : issueType.hashCode());
        result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
        result = prime * result + ((previousStatus == null) ? 0 : previousStatus.hashCode());
        result = prime * result + ((getEventDate() == null) ? 0 : getEventDate().hashCode());
        result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
        IssueHistory other = (IssueHistory) obj;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (issueType == null) {
            if (other.issueType != null)
                return false;
        } else if (!issueType.equals(other.issueType))
            return false;
        if (getKey() == null) {
            if (other.getKey() != null)
                return false;
        } else if (!getKey().equals(other.getKey()))
            return false;
        if (previousStatus == null) {
            if (other.previousStatus != null)
                return false;
        } else if (!previousStatus.equals(other.previousStatus))
            return false;
        if (getEventDate() == null) {
            if (other.getEventDate() != null)
                return false;
        } else if (!getEventDate().equals(other.getEventDate()))
            return false;
        if (summary == null) {
            if (other.summary != null)
                return false;
        } else if (!summary.equals(other.summary))
            return false;
        return true;
    }

}
