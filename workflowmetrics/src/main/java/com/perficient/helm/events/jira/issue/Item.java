package com.perficient.helm.events.jira.issue;

public class Item {
    private String field;
    private String fieldtype;
    private String from;
    private String fromString;
    private String to;
    private String toString;
    
    public String getField() {
        return field;
    }
    public Item setField(String field) {
        this.field = field;
    
        return this;
    }
    public String getFieldtype() {
        return fieldtype;
    }
    public Item setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    
        return this;
    }
    public String getFrom() {
        return from;
    }
    public Item setFrom(String from) {
        this.from = from;
    
        return this;
    }
    public String getFromString() {
        return fromString;
    }
    public Item setFromString(String fromString) {
        this.fromString = fromString;
    
        return this;
    }
    public String getTo() {
        return to;
    }
    public Item setTo(String to) {
        this.to = to;
    
        return this;
    }
    public String getToString() {
        return toString;
    }
    public Item setToString(String toString) {
        this.toString = toString;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        result = prime * result + ((fieldtype == null) ? 0 : fieldtype.hashCode());
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((fromString == null) ? 0 : fromString.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        result = prime * result + ((toString == null) ? 0 : toString.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        if (fieldtype == null) {
            if (other.fieldtype != null)
                return false;
        } else if (!fieldtype.equals(other.fieldtype))
            return false;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from))
            return false;
        if (fromString == null) {
            if (other.fromString != null)
                return false;
        } else if (!fromString.equals(other.fromString))
            return false;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        if (toString == null) {
            if (other.toString != null)
                return false;
        } else if (!toString.equals(other.toString))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Item [field=" + field + ", fieldtype=" + fieldtype + ", from=" + from + ", fromString=" + fromString
                + ", to=" + to + ", toString=" + toString + "]";
    }
}
