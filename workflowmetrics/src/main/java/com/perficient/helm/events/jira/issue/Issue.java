package com.dtcc.workflowmetrics.metricsitems.jira.issue;

public class Issue {
    private String expand;
    private String id;
    private String self;
    private String key;
    private IssueFields fields;
    private Changelog changelog;
   
    public String getExpand() {
        return expand;
    }

    public Issue setExpand(String expand) {
        this.expand = expand;

        return this;
    }

    public String getId() {
        return id;
    }

    public Issue setId(String id) {
        this.id = id;

        return this;
    }

    public String getSelf() {
        return self;
    }

    public Issue setSelf(String self) {
        this.self = self;

        return this;
    }

    public String getKey() {
        return key;
    }

    public Issue setKey(String key) {
        this.key = key;

        return this;
    }

    public IssueFields getFields() {
        return fields;
    }

    public Issue setFields(IssueFields fields) {
        this.fields = fields;

        return this;
    }

    public Changelog getChangelog() {
        return changelog;
    }

    public Issue setChangelog(Changelog changelog) {
        this.changelog = changelog;

        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((changelog == null) ? 0 : changelog.hashCode());
        result = prime * result + ((expand == null) ? 0 : expand.hashCode());
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
        Issue other = (Issue) obj;
        if (changelog == null) {
            if (other.changelog != null) {
                return false;
            }
        } else if (!changelog.equals(other.changelog)) {
            return false;
        }
        if (expand == null) {
            if (other.expand != null) {
                return false;
            }
        } else if (!expand.equals(other.expand)) {
            return false;
        }
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
