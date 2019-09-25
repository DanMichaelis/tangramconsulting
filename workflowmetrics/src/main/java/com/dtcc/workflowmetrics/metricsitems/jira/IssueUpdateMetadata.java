package com.dtcc.workflowmetrics.metricsitems.jira;

import java.util.ArrayList;

public class IssueUpdateMetadata {
    ArrayList<Field> fields;

    public ArrayList<Field> getFields() {
        return fields;
    }

    public IssueUpdateMetadata setFields(ArrayList<Field> fields) {
        this.fields = fields;
    
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
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
        IssueUpdateMetadata other = (IssueUpdateMetadata) obj;
        if (fields == null) {
            if (other.fields != null)
                return false;
        } else if (!fields.equals(other.fields))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IssueUpdateMetadata [fields=" + fields + "]";
    }
    
    
    
}
