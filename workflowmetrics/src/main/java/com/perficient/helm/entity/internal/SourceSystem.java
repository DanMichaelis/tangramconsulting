package com.perficient.helm.entity.internal;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.helm.dao.SourceSystemDao;

public class SourceSystem {
    
    private static ArrayList<SourceSystem> SOURCE_SYSTEMS = new ArrayList<SourceSystem>(); 
    
    private String id;
    private String shortDescription;
    private String description;
    
    @Autowired
    private SourceSystemDao dao;
    
    public final String getId() {
        return id;
    }
    
    public final String getShortDescription() {
        return shortDescription;
    }
   
    public final String getDescription() {
        return description;
    }
    
    private final void initialize() {
        dao.findAll();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
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
        SourceSystem other = (SourceSystem) obj;
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
        if (shortDescription == null) {
            if (other.shortDescription != null) {
                return false;
            }
        } else if (!shortDescription.equals(other.shortDescription)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SourceSystem [id=");
        builder.append(id);
        builder.append(", shortDescription=");
        builder.append(shortDescription);
        builder.append(", description=");
        builder.append(description);
        builder.append("]");
        return builder.toString();
    }
}
