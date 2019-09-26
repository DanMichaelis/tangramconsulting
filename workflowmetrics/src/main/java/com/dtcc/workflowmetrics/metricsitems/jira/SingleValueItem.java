package com.dtcc.workflowmetrics.metricsitems.jira;

public class SingleValueItem {
    private String item;

    public String getLastViewed() {
        return item;
    }

    public SingleValueItem setLastViewed(String lastViewed) {
        this.item = lastViewed;
    
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
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
        SingleValueItem other = (SingleValueItem) obj;
        if (item == null) {
            if (other.item != null) {
                return false;
            }
        } else if (!item.equals(other.item)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LastViewed [lastViewed=");
        builder.append(item);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
