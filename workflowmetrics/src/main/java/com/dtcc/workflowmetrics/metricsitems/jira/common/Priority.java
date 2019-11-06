package com.dtcc.workflowmetrics.metricsitems.jira.common;

public class Priority {
    private String self;
    private String iconUrl;
    private String name;
    private String id;
    public String getSelf() {
        return self;
    }
    public Priority setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public String getIconUrl() {
        return iconUrl;
    }
    public Priority setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public Priority setName(String name) {
        this.name = name;
    
        return this;
    }
    public String getId() {
        return id;
    }
    public Priority setId(String id) {
        this.id = id;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Priority other = (Priority) obj;
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
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
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
        builder.append("Priority [self=");
        builder.append(self);
        builder.append(", iconUrl=");
        builder.append(iconUrl);
        builder.append(", name=");
        builder.append(name);
        builder.append(", id=");
        builder.append(id);
        builder.append("]");
        return builder.toString();
    }
}
