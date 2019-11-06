package com.dtcc.workflowmetrics.metricsitems.jira.common;

public class StatusCategory {
    private String self;
    private Integer id;
    private String key;
    private String colorName;
    private String name;
    public String getSelf() {
        return self;
    }
    public StatusCategory setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public Integer getId() {
        return id;
    }
    public StatusCategory setId(Integer id) {
        this.id = id;
    
        return this;
    }
    public String getKey() {
        return key;
    }
    public StatusCategory setKey(String key) {
        this.key = key;
    
        return this;
    }
    public String getColorName() {
        return colorName;
    }
    public StatusCategory setColorName(String colorName) {
        this.colorName = colorName;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public StatusCategory setName(String name) {
        this.name = name;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((colorName == null) ? 0 : colorName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
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
        StatusCategory other = (StatusCategory) obj;
        if (colorName == null) {
            if (other.colorName != null) {
                return false;
            }
        } else if (!colorName.equals(other.colorName)) {
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
        builder.append("StatusCategory [self=");
        builder.append(self);
        builder.append(", id=");
        builder.append(id);
        builder.append(", key=");
        builder.append(key);
        builder.append(", colorName=");
        builder.append(colorName);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }  
    
}
                        