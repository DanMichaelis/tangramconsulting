package com.dtcc.workflowmetrics.metricsitems.jira;

public class LinkedIssue {
    private String id;
    private String key;
    private String self;
    private LinkedIssueFields fields;

    public String getId() {
        return id;
    }

    public LinkedIssue setId(String id) {
        this.id = id;

        return this;
    }

    public String getKey() {
        return key;
    }

    public LinkedIssue setKey(String key) {
        this.key = key;

        return this;
    }

    public String getSelf() {
        return self;
    }

    public LinkedIssue setSelf(String self) {
        this.self = self;

        return this;
    }

    public LinkedIssueFields getFields() {
        return fields;
    }

    public LinkedIssue setFields(LinkedIssueFields fields) {
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
        LinkedIssue other = (LinkedIssue) obj;
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

}
