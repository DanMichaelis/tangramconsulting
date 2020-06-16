package com.perficient.helm.entity;

import java.io.Serializable;

public class ProjectId implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 231985438713995681L;
    private String id;
    private int sourceSystemId;
    
    public ProjectId() {
        
    }

    public ProjectId(String id, int sourceSystemId) {
        super();
        this.id = id;
        this.sourceSystemId = sourceSystemId;
    }

    public final String getId() {
        return id;
    }

    public final ProjectId setId(String id) {
        this.id = id;
    
        return this;
    }

    public final int getSourceSystemId() {
        return sourceSystemId;
    }

    public final ProjectId setSourceSystemId(int sourceSystemId) {
        this.sourceSystemId = sourceSystemId;
    
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + sourceSystemId;
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
        ProjectId other = (ProjectId) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (sourceSystemId != other.sourceSystemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProjectId [id=");
        builder.append(id);
        builder.append(", sourceSystemId=");
        builder.append(sourceSystemId);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
