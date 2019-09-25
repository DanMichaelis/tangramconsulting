package com.dtcc.workflowmetrics.metricsitems.jira;

import java.util.ArrayList;

public class IssueFields {
    private ArrayList<CustomField> customFields;
    private Resolution resolution;
    private SingleValueItem lastViewed;
    private SingleValueItem aggregatetimeinitialestimate;
    private ArrayList<IssueLink> issuelinks;
    private IssueType issuetype;
    private SingleValueItem timetracking;
    private SingleValueItem environment;
    private SingleValueItem timeestimate;
    private SingleValueItem workratio;
    private ArrayList<String> labels;
    private Reporter reporter;
    private Watches watches;
    private String description;
    private ArrayList<FixVersion> fixVersions;
    private Priority priority;
    private String created;
    private ArrayList<SingleValueItem> attachment;
    private Reporter assignee;
    public ArrayList<CustomField> getCustomFields() {
        return customFields;
    }
    public IssueFields setCustomFields(ArrayList<CustomField> customFields) {
        this.customFields = customFields;
    
        return this;
    }
    public Resolution getResolution() {
        return resolution;
    }
    public IssueFields setResolution(Resolution resolution) {
        this.resolution = resolution;
    
        return this;
    }
    public SingleValueItem getLastViewed() {
        return lastViewed;
    }
    public IssueFields setLastViewed(SingleValueItem lastViewed) {
        this.lastViewed = lastViewed;
    
        return this;
    }
    public SingleValueItem getAggregatetimeinitialestimate() {
        return aggregatetimeinitialestimate;
    }
    public IssueFields setAggregatetimeinitialestimate(SingleValueItem aggregatetimeinitialestimate) {
        this.aggregatetimeinitialestimate = aggregatetimeinitialestimate;
    
        return this;
    }
    public ArrayList<IssueLink> getIssuelinks() {
        return issuelinks;
    }
    public IssueFields setIssuelinks(ArrayList<IssueLink> issuelinks) {
        this.issuelinks = issuelinks;
    
        return this;
    }
    public IssueType getIssuetype() {
        return issuetype;
    }
    public IssueFields setIssuetype(IssueType issuetype) {
        this.issuetype = issuetype;
    
        return this;
    }
    public SingleValueItem getTimetracking() {
        return timetracking;
    }
    public IssueFields setTimetracking(SingleValueItem timetracking) {
        this.timetracking = timetracking;
    
        return this;
    }
    public SingleValueItem getEnvironment() {
        return environment;
    }
    public IssueFields setEnvironment(SingleValueItem environment) {
        this.environment = environment;
    
        return this;
    }
    public SingleValueItem getTimeestimate() {
        return timeestimate;
    }
    public IssueFields setTimeestimate(SingleValueItem timeestimate) {
        this.timeestimate = timeestimate;
    
        return this;
    }
    public SingleValueItem getWorkratio() {
        return workratio;
    }
    public IssueFields setWorkratio(SingleValueItem workratio) {
        this.workratio = workratio;
    
        return this;
    }
    public ArrayList<String> getLabels() {
        return labels;
    }
    public IssueFields setLabels(ArrayList<String> labels) {
        this.labels = labels;
    
        return this;
    }
    public Reporter getReporter() {
        return reporter;
    }
    public IssueFields setReporter(Reporter reporter) {
        this.reporter = reporter;
    
        return this;
    }
    public Watches getWatches() {
        return watches;
    }
    public IssueFields setWatches(Watches watches) {
        this.watches = watches;
    
        return this;
    }
    public String getDescription() {
        return description;
    }
    public IssueFields setDescription(String description) {
        this.description = description;
    
        return this;
    }
    public ArrayList<FixVersion> getFixVersions() {
        return fixVersions;
    }
    public IssueFields setFixVersions(ArrayList<FixVersion> fixVersions) {
        this.fixVersions = fixVersions;
    
        return this;
    }
    public Priority getPriority() {
        return priority;
    }
    public IssueFields setPriority(Priority priority) {
        this.priority = priority;
    
        return this;
    }
    public String getCreated() {
        return created;
    }
    public IssueFields setCreated(String created) {
        this.created = created;
    
        return this;
    }
    public ArrayList<SingleValueItem> getAttachment() {
        return attachment;
    }
    public IssueFields setAttachment(ArrayList<SingleValueItem> attachment) {
        this.attachment = attachment;
    
        return this;
    }
    public Reporter getAssignee() {
        return assignee;
    }

    public IssueFields setAssignee(Reporter assignee) {
        this.assignee = assignee;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((aggregatetimeinitialestimate == null) ? 0 : aggregatetimeinitialestimate.hashCode());
        result = prime * result + ((assignee == null) ? 0 : assignee.hashCode());
        result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((customFields == null) ? 0 : customFields.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((environment == null) ? 0 : environment.hashCode());
        result = prime * result + ((fixVersions == null) ? 0 : fixVersions.hashCode());
        result = prime * result + ((issuelinks == null) ? 0 : issuelinks.hashCode());
        result = prime * result + ((issuetype == null) ? 0 : issuetype.hashCode());
        result = prime * result + ((labels == null) ? 0 : labels.hashCode());
        result = prime * result + ((lastViewed == null) ? 0 : lastViewed.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((reporter == null) ? 0 : reporter.hashCode());
        result = prime * result + ((resolution == null) ? 0 : resolution.hashCode());
        result = prime * result + ((timeestimate == null) ? 0 : timeestimate.hashCode());
        result = prime * result + ((timetracking == null) ? 0 : timetracking.hashCode());
        result = prime * result + ((watches == null) ? 0 : watches.hashCode());
        result = prime * result + ((workratio == null) ? 0 : workratio.hashCode());
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
        IssueFields other = (IssueFields) obj;
        if (aggregatetimeinitialestimate == null) {
            if (other.aggregatetimeinitialestimate != null) {
                return false;
            }
        } else if (!aggregatetimeinitialestimate.equals(other.aggregatetimeinitialestimate)) {
            return false;
        }
        if (assignee == null) {
            if (other.assignee != null) {
                return false;
            }
        } else if (!assignee.equals(other.assignee)) {
            return false;
        }
        if (attachment == null) {
            if (other.attachment != null) {
                return false;
            }
        } else if (!attachment.equals(other.attachment)) {
            return false;
        }
        if (created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!created.equals(other.created)) {
            return false;
        }
        if (customFields == null) {
            if (other.customFields != null) {
                return false;
            }
        } else if (!customFields.equals(other.customFields)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (environment == null) {
            if (other.environment != null) {
                return false;
            }
        } else if (!environment.equals(other.environment)) {
            return false;
        }
        if (fixVersions == null) {
            if (other.fixVersions != null) {
                return false;
            }
        } else if (!fixVersions.equals(other.fixVersions)) {
            return false;
        }
        if (issuelinks == null) {
            if (other.issuelinks != null) {
                return false;
            }
        } else if (!issuelinks.equals(other.issuelinks)) {
            return false;
        }
        if (issuetype == null) {
            if (other.issuetype != null) {
                return false;
            }
        } else if (!issuetype.equals(other.issuetype)) {
            return false;
        }
        if (labels == null) {
            if (other.labels != null) {
                return false;
            }
        } else if (!labels.equals(other.labels)) {
            return false;
        }
        if (lastViewed == null) {
            if (other.lastViewed != null) {
                return false;
            }
        } else if (!lastViewed.equals(other.lastViewed)) {
            return false;
        }
        if (priority == null) {
            if (other.priority != null) {
                return false;
            }
        } else if (!priority.equals(other.priority)) {
            return false;
        }
        if (reporter == null) {
            if (other.reporter != null) {
                return false;
            }
        } else if (!reporter.equals(other.reporter)) {
            return false;
        }
        if (resolution == null) {
            if (other.resolution != null) {
                return false;
            }
        } else if (!resolution.equals(other.resolution)) {
            return false;
        }
        if (timeestimate == null) {
            if (other.timeestimate != null) {
                return false;
            }
        } else if (!timeestimate.equals(other.timeestimate)) {
            return false;
        }
        if (timetracking == null) {
            if (other.timetracking != null) {
                return false;
            }
        } else if (!timetracking.equals(other.timetracking)) {
            return false;
        }
        if (watches == null) {
            if (other.watches != null) {
                return false;
            }
        } else if (!watches.equals(other.watches)) {
            return false;
        }
        if (workratio == null) {
            if (other.workratio != null) {
                return false;
            }
        } else if (!workratio.equals(other.workratio)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IssueFields [customFields=");
        builder.append(customFields);
        builder.append(", resolution=");
        builder.append(resolution);
        builder.append(", lastViewed=");
        builder.append(lastViewed);
        builder.append(", aggregatetimeinitialestimate=");
        builder.append(aggregatetimeinitialestimate);
        builder.append(", issuelinks=");
        builder.append(issuelinks);
        builder.append(", issuetype=");
        builder.append(issuetype);
        builder.append(", timetracking=");
        builder.append(timetracking);
        builder.append(", environment=");
        builder.append(environment);
        builder.append(", timeestimate=");
        builder.append(timeestimate);
        builder.append(", workratio=");
        builder.append(workratio);
        builder.append(", labels=");
        builder.append(labels);
        builder.append(", reporter=");
        builder.append(reporter);
        builder.append(", watches=");
        builder.append(watches);
        builder.append(", description=");
        builder.append(description);
        builder.append(", fixVersions=");
        builder.append(fixVersions);
        builder.append(", priority=");
        builder.append(priority);
        builder.append(", created=");
        builder.append(created);
        builder.append(", attachment=");
        builder.append(attachment);
        builder.append(", assignee=");
        builder.append(assignee);
        builder.append("]");
        return builder.toString();
    }
}
