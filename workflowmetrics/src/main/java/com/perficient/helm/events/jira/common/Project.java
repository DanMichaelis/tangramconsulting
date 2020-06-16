package com.dtcc.workflowmetrics.metricsitems.jira.common;

public class Project {
    private String self;
    private Integer id;
    private String key;
    private String name;
    private String projectTypeKey;
    
    public String getSelf() {
        return self;
    }
    public Project setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public Integer getId() {
        return id;
    }
    public Project setId(Integer id) {
        this.id = id;
    
        return this;
    }
    public String getKey() {
        return key;
    }
    public Project setKey(String key) {
        this.key = key;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public Project setName(String name) {
        this.name = name;
    
        return this;
    }
    public String getProjectTypeKey() {
        return projectTypeKey;
    }
    public Project setProjectTypeKey(String projectTypeKey) {
        this.projectTypeKey = projectTypeKey;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((projectTypeKey == null) ? 0 : projectTypeKey.hashCode());
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
        Project other = (Project) obj;
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
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (projectTypeKey == null) {
            if (other.projectTypeKey != null) {
                return false;
            }
        } else if (!projectTypeKey.equals(other.projectTypeKey)) {
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
        builder.append("Project [self=");
        builder.append(self);
        builder.append(", id=");
        builder.append(id);
        builder.append(", key=");
        builder.append(key);
        builder.append(", name=");
        builder.append(name);
        builder.append(", projectTypeKey=");
        builder.append(projectTypeKey);
        builder.append("]");
        return builder.toString();
    }
    
}
