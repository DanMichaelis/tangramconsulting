package com.dtcc.workflowmetrics.metricsitems.jira.common;

public class Issuetype {
    private String self;
    private String id;
    private String description;
    private String iconUrl;
    private String name;
    private Boolean subtask;
    private String avatarId;
    public String getSelf() {
        return self;
    }
    public Issuetype setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public String getId() {
        return id;
    }
    public Issuetype setId(String id) {
        this.id = id;
    
        return this;
    }
    public String getDescription() {
        return description;
    }
    public Issuetype setDescription(String description) {
        this.description = description;
    
        return this;
    }
    public String getIconUrl() {
        return iconUrl;
    }
    public Issuetype setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public Issuetype setName(String name) {
        this.name = name;
    
        return this;
    }
    public Boolean getSubtask() {
        return subtask;
    }
    public Issuetype setSubtask(Boolean subtask) {
        this.subtask = subtask;
    
        return this;
    }
    public String getAvatarId() {
        return avatarId;
    }
    public Issuetype setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((avatarId == null) ? 0 : avatarId.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((self == null) ? 0 : self.hashCode());
        result = prime * result + ((subtask == null) ? 0 : subtask.hashCode());
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
        Issuetype other = (Issuetype) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (avatarId == null) {
            if (other.avatarId != null) {
                return false;
            }
        } else if (!avatarId.equals(other.avatarId)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (iconUrl == null) {
            if (other.iconUrl != null) {
                return false;
            }
        } else if (!iconUrl.equals(other.iconUrl)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (self == null) {
            if (other.self != null) {
                return false;
            }
        } else if (!self.equals(other.self)) {
            return false;
        }
        if (subtask == null) {
            if (other.subtask != null) {
                return false;
            }
        } else if (!subtask.equals(other.subtask)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IssueType [self=");
        builder.append(self);
        builder.append(", id=");
        builder.append(id);
        builder.append(", description=");
        builder.append(description);
        builder.append(", iconUrl=");
        builder.append(iconUrl);
        builder.append(", Name=");
        builder.append(name);
        builder.append(", subtask=");
        builder.append(subtask);
        builder.append(", avatarId=");
        builder.append(avatarId);
        builder.append("]");
        return builder.toString();
    }
    
}
