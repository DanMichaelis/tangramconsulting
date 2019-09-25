package com.dtcc.workflowmetrics.metricsitems.jira;

public class SingleValueItem {
    private String lastViewed;

    public String getLastViewed() {
        return lastViewed;
    }

    public SingleValueItem setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lastViewed == null) ? 0 : lastViewed.hashCode());
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
        if (lastViewed == null) {
            if (other.lastViewed != null) {
                return false;
            }
        } else if (!lastViewed.equals(other.lastViewed)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LastViewed [lastViewed=");
        builder.append(lastViewed);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
