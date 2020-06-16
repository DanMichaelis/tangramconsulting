package com.perficient.helm.events.jira;

import java.util.ArrayList;

public class Operation {
    private ArrayList<LinkGroup> linkGroup;
    private Object additionalProperties;

    public ArrayList<LinkGroup> getLinkGroup() {
        return linkGroup;
    }

    public Operation setLinkGroup(ArrayList<LinkGroup> linkGroup) {
        this.linkGroup = linkGroup;

        return this;
    }

    public Object getAdditionalProperties() {
        return additionalProperties;
    }

    public Operation setAdditionalProperties(Object additionalProperties) {
        this.additionalProperties = additionalProperties;

        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
        result = prime * result + ((linkGroup == null) ? 0 : linkGroup.hashCode());
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
        Operation other = (Operation) obj;
        if (additionalProperties == null) {
            if (other.additionalProperties != null)
                return false;
        } else if (!additionalProperties.equals(other.additionalProperties))
            return false;
        if (linkGroup == null) {
            if (other.linkGroup != null)
                return false;
        } else if (!linkGroup.equals(other.linkGroup))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Operation [linkGroup=" + linkGroup + ", additionalProperties=" + additionalProperties + "]";
    }
    
}
