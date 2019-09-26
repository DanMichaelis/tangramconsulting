package com.dtcc.workflowmetrics.metricsitems.jira.webhook;

public class WebhookTransition {
    private Integer workflowId;
    private String workflowName;
    private Integer transitionId;
    private String transitionName;
    private String from_status;
    private String to_status;

    public String getTransitionName() {
        return transitionName;
    }
    public WebhookTransition setTransitionName(String transitionName) {
        this.transitionName = transitionName;
    
        return this;
    }
    
    public Integer getWorkflowId() {
        return workflowId;
    }
    public WebhookTransition setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    
        return this;
    }
    public String getWorkflowName() {
        return workflowName;
    }
    public WebhookTransition setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    
        return this;
    }
    public Integer getTransitionId() {
        return transitionId;
    }
    public WebhookTransition setTransitionId(Integer transitionId) {
        this.transitionId = transitionId;
    
        return this;
    }
    public String getFrom_status() {
        return from_status;
    }
    public WebhookTransition setFrom_status(String from_status) {
        this.from_status = from_status;
    
        return this;
    }
    public String getTo_status() {
        return to_status;
    }
    public WebhookTransition setTo_status(String to_status) {
        this.to_status = to_status;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((from_status == null) ? 0 : from_status.hashCode());
        result = prime * result + ((to_status == null) ? 0 : to_status.hashCode());
        result = prime * result + ((transitionId == null) ? 0 : transitionId.hashCode());
        result = prime * result + ((transitionName == null) ? 0 : transitionName.hashCode());
        result = prime * result + ((workflowId == null) ? 0 : workflowId.hashCode());
        result = prime * result + ((workflowName == null) ? 0 : workflowName.hashCode());
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
        WebhookTransition other = (WebhookTransition) obj;
        if (from_status == null) {
            if (other.from_status != null) {
                return false;
            }
        } else if (!from_status.equals(other.from_status)) {
            return false;
        }
        if (to_status == null) {
            if (other.to_status != null) {
                return false;
            }
        } else if (!to_status.equals(other.to_status)) {
            return false;
        }
        if (transitionId == null) {
            if (other.transitionId != null) {
                return false;
            }
        } else if (!transitionId.equals(other.transitionId)) {
            return false;
        }
        if (transitionName == null) {
            if (other.transitionName != null) {
                return false;
            }
        } else if (!transitionName.equals(other.transitionName)) {
            return false;
        }
        if (workflowId == null) {
            if (other.workflowId != null) {
                return false;
            }
        } else if (!workflowId.equals(other.workflowId)) {
            return false;
        }
        if (workflowName == null) {
            if (other.workflowName != null) {
                return false;
            }
        } else if (!workflowName.equals(other.workflowName)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WebhookTransition [workflowId=");
        builder.append(workflowId);
        builder.append(", workflowName=");
        builder.append(workflowName);
        builder.append(", transitionId=");
        builder.append(transitionId);
        builder.append(", transitionName=");
        builder.append(transitionName);
        builder.append(", from_status=");
        builder.append(from_status);
        builder.append(", to_status=");
        builder.append(to_status);
        builder.append("]");
        return builder.toString();
    }
    
}
