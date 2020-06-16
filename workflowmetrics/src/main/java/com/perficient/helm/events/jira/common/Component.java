package com.perficient.helm.events.jira.common;

public class Component {
    private String self;
    private Integer id;
    private String name;
    private String description;
    public String getSelf() {
        return self;
    }
    public Component setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public Integer getId() {
        return id;
    }
    public Component setId(Integer id) {
        this.id = id;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public Component setName(String name) {
        this.name = name;
    
        return this;
    }
    public String getDescription() {
        return description;
    }
    public Component setDescription(String description) {
        this.description = description;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        Component other = (Component) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
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
        builder.append("Component [self=");
        builder.append(self);
        builder.append(", id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append("]");
        return builder.toString();
    }
}
