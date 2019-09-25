package com.dtcc.workflowmetrics.metricsitems;

public class LinkType {
    private String id;
    private String name;
    private String inward;
    private String outward;
    private String self;
    public String getId() {
        return id;
    }
    public LinkType setId(String id) {
        this.id = id;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public LinkType setName(String name) {
        this.name = name;
    
        return this;
    }
    public String getInward() {
        return inward;
    }
    public LinkType setInward(String inward) {
        this.inward = inward;
    
        return this;
    }
    public String getOutward() {
        return outward;
    }
    public LinkType setOutward(String outward) {
        this.outward = outward;
    
        return this;
    }
    public String getSelf() {
        return self;
    }
    public LinkType setSelf(String self) {
        this.self = self;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((inward == null) ? 0 : inward.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((outward == null) ? 0 : outward.hashCode());
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
        LinkType other = (LinkType) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (inward == null) {
            if (other.inward != null) {
                return false;
            }
        } else if (!inward.equals(other.inward)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (outward == null) {
            if (other.outward != null) {
                return false;
            }
        } else if (!outward.equals(other.outward)) {
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
        builder.append("LinkType [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", inward=");
        builder.append(inward);
        builder.append(", outward=");
        builder.append(outward);
        builder.append(", self=");
        builder.append(self);
        builder.append("]");
        return builder.toString();
    }
}
