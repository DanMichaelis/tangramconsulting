package com.dtcc.workflowmetrics.metricsitems.jira.common;

public class CustomField {
    private String self;
    private String value;
    private Integer id;
    
    public String getSelf() {
        return self;
    }
    public CustomField setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public String getValue() {
        return value;
    }
    public CustomField setValue(String value) {
        this.value = value;
    
        return this;
    }
    public Integer getId() {
        return id;
    }
    public CustomField setId(Integer id) {
        this.id = id;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((self == null) ? 0 : self.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        CustomField other = (CustomField) obj;
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
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CustomField [self=");
        builder.append(self);
        builder.append(", value=");
        builder.append(value);
        builder.append(", id=");
        builder.append(id);
        builder.append("]");
        return builder.toString();
    }
}
