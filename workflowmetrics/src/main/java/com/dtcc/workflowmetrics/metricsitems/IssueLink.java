package com.dtcc.workflowmetrics.metricsitems;

public class IssueLink {
    private String id;
    private String self;
    private LinkType type;
    private LinkedIssue inwardIssue;
    private LinkedIssue outwardIssue;

    public String getId() {
        return id;
    }

    public IssueLink setId(String id) {
        this.id = id;

        return this;
    }

    public String getSelf() {
        return self;
    }

    public IssueLink setSelf(String self) {
        this.self = self;

        return this;
    }

    public LinkType getType() {
        return type;
    }

    public IssueLink setType(LinkType type) {
        this.type = type;

        return this;
    }

    public LinkedIssue getInwardIssue() {
        return inwardIssue;
    }

    public IssueLink setInwardIssue(LinkedIssue inwardIssue) {
        this.inwardIssue = inwardIssue;

        return this;
    }

    public LinkedIssue getOutwardIssue() {
        return outwardIssue;
    }

    public IssueLink setOutwardIssue(LinkedIssue outwardIssue) {
        this.outwardIssue = outwardIssue;

        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((inwardIssue == null) ? 0 : inwardIssue.hashCode());
        result = prime * result + ((outwardIssue == null) ? 0 : outwardIssue.hashCode());
        result = prime * result + ((self == null) ? 0 : self.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        IssueLink other = (IssueLink) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (inwardIssue == null) {
            if (other.inwardIssue != null) {
                return false;
            }
        } else if (!inwardIssue.equals(other.inwardIssue)) {
            return false;
        }
        if (outwardIssue == null) {
            if (other.outwardIssue != null) {
                return false;
            }
        } else if (!outwardIssue.equals(other.outwardIssue)) {
            return false;
        }
        if (self == null) {
            if (other.self != null) {
                return false;
            }
        } else if (!self.equals(other.self)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IssueLink [id=");
        builder.append(id);
        builder.append(", self=");
        builder.append(self);
        builder.append(", type=");
        builder.append(type);
        builder.append(", inwardIssue=");
        builder.append(inwardIssue);
        builder.append(", outwardIssue=");
        builder.append(outwardIssue);
        builder.append("]");
        return builder.toString();
    }

}
