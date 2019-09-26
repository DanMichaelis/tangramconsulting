package com.dtcc.workflowmetrics.metricsitems.jira.webhook;

public class WebhookIssue {
    private Integer id;
    private String self;
    private String key;
    private Fields fields;
    
    public Integer getId() {
        return id;
    }
    public WebhookIssue setId(Integer id) {
        this.id = id;
    
        return this;
    }
    public String getSelf() {
        return self;
    }
    public WebhookIssue setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public String getKey() {
        return key;
    }
    public WebhookIssue setKey(String key) {
        this.key = key;
    
        return this;
    }
    public Fields getFields() {
        return fields;
    }
    public WebhookIssue setFields(Fields fields) {
        this.fields = fields;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((self == null) ? 0 : self.hashCode());
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
        WebhookIssue other = (WebhookIssue) obj;
        if (fields == null) {
            if (other.fields != null) {
                return false;
            }
        } else if (!fields.equals(other.fields)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        if (self == null) {
            if (other.self != null) {
                return false;
            }
        } else if (!self.equals(other.self)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WebhookIssue [id=");
        builder.append(id);
        builder.append(", self=");
        builder.append(self);
        builder.append(", key=");
        builder.append(key);
        builder.append(", fields=");
        builder.append(fields);
        builder.append("]");
        return builder.toString();
    }
}
