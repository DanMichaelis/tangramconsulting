package com.dtcc.workflowmetrics.metricsitems;

public class FixVersion {
    private String self;
    private String id;
    private String description;
    private String name;
    private Boolean archived;
    private Boolean released;
    private String releaseDate;
    public String getSelf() {
        return self;
    }
    public FixVersion setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public String getId() {
        return id;
    }
    public FixVersion setId(String id) {
        this.id = id;
    
        return this;
    }
    public String getDescription() {
        return description;
    }
    public FixVersion setDescription(String description) {
        this.description = description;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public FixVersion setName(String name) {
        this.name = name;
    
        return this;
    }
    public Boolean getArchived() {
        return archived;
    }
    public FixVersion setArchived(Boolean archived) {
        this.archived = archived;
    
        return this;
    }
    public Boolean getReleased() {
        return released;
    }
    public FixVersion setReleased(Boolean released) {
        this.released = released;
    
        return this;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public FixVersion setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((archived == null) ? 0 : archived.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
        result = prime * result + ((released == null) ? 0 : released.hashCode());
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
        FixVersion other = (FixVersion) obj;
        if (archived == null) {
            if (other.archived != null) {
                return false;
            }
        } else if (!archived.equals(other.archived)) {
            return false;
        }
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
        if (releaseDate == null) {
            if (other.releaseDate != null) {
                return false;
            }
        } else if (!releaseDate.equals(other.releaseDate)) {
            return false;
        }
        if (released == null) {
            if (other.released != null) {
                return false;
            }
        } else if (!released.equals(other.released)) {
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
        builder.append("FixVersion [self=");
        builder.append(self);
        builder.append(", id=");
        builder.append(id);
        builder.append(", description=");
        builder.append(description);
        builder.append(", name=");
        builder.append(name);
        builder.append(", archived=");
        builder.append(archived);
        builder.append(", released=");
        builder.append(released);
        builder.append(", releaseDate=");
        builder.append(releaseDate);
        builder.append("]");
        return builder.toString();
    }
    
}
