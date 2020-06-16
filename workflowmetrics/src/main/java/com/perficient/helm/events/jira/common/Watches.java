package com.perficient.helm.events.jira.common;

public class Watches {
    private String self;
    private Integer watchCount;
    private Boolean isWatching;
    public String getSelf() {
        return self;
    }
    public Watches setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public Integer getWatchCount() {
        return watchCount;
    }
    public Watches setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    
        return this;
    }
    public Boolean getIsWatching() {
        return isWatching;
    }
    public Watches setIsWatching(Boolean isWatching) {
        this.isWatching = isWatching;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isWatching == null) ? 0 : isWatching.hashCode());
        result = prime * result + ((self == null) ? 0 : self.hashCode());
        result = prime * result + ((watchCount == null) ? 0 : watchCount.hashCode());
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
        Watches other = (Watches) obj;
        if (isWatching == null) {
            if (other.isWatching != null) {
                return false;
            }
        } else if (!isWatching.equals(other.isWatching)) {
            return false;
        }
        if (self == null) {
            if (other.self != null) {
                return false;
            }
        } else if (!self.equals(other.self)) {
            return false;
        }
        if (watchCount == null) {
            if (other.watchCount != null) {
                return false;
            }
        } else if (!watchCount.equals(other.watchCount)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Watches [self=");
        builder.append(self);
        builder.append(", watchCount=");
        builder.append(watchCount);
        builder.append(", isWatching=");
        builder.append(isWatching);
        builder.append("]");
        return builder.toString();
    }
    
    
}
