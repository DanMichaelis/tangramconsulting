package com.perficient.helm.events.jira.webhook;

import com.perficient.helm.events.jira.common.User;

public class WebhookData {
    private WebhookTransition transition;
    private String comment;
    private User user;
    private WebhookIssue issue;
    private Long timestamp;
    
    public WebhookTransition getTransition() {
        return transition;
    }
    public WebhookData setTransition(WebhookTransition transition) {
        this.transition = transition;
    
        return this;
    }
    public String getComment() {
        return comment;
    }
    public WebhookData setComment(String comment) {
        this.comment = comment;
    
        return this;
    }
    public User getUser() {
        return user;
    }
    public WebhookData setUser(User user) {
        this.user = user;
    
        return this;
    }
    public WebhookIssue getIssue() {
        return issue;
    }
    public WebhookData setIssue(WebhookIssue issue) {
        this.issue = issue;
    
        return this;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public WebhookData setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((issue == null) ? 0 : issue.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
        result = prime * result + ((transition == null) ? 0 : transition.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        WebhookData other = (WebhookData) obj;
        if (comment == null) {
            if (other.comment != null) {
                return false;
            }
        } else if (!comment.equals(other.comment)) {
            return false;
        }
        if (issue == null) {
            if (other.issue != null) {
                return false;
            }
        } else if (!issue.equals(other.issue)) {
            return false;
        }
        if (timestamp == null) {
            if (other.timestamp != null) {
                return false;
            }
        } else if (!timestamp.equals(other.timestamp)) {
            return false;
        }
        if (transition == null) {
            if (other.transition != null) {
                return false;
            }
        } else if (!transition.equals(other.transition)) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WebhookData [transition=");
        builder.append(transition);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", user=");
        builder.append(user);
        builder.append(", issue=");
        builder.append(issue);
        builder.append(", timestamp=");
        builder.append(timestamp);
        builder.append("]");
        return builder.toString();
    }
    
    
}
