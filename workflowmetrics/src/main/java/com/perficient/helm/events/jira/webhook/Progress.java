package com.perficient.helm.events.jira.webhook;

public class Progress {
    private Integer progress;
    private Integer total;
    public Integer getProgress() {
        return progress;
    }
    public Progress setProgress(Integer progress) {
        this.progress = progress;
    
        return this;
    }
    public Integer getTotal() {
        return total;
    }
    public Progress setTotal(Integer total) {
        this.total = total;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((progress == null) ? 0 : progress.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
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
        Progress other = (Progress) obj;
        if (progress == null) {
            if (other.progress != null) {
                return false;
            }
        } else if (!progress.equals(other.progress)) {
            return false;
        }
        if (total == null) {
            if (other.total != null) {
                return false;
            }
        } else if (!total.equals(other.total)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Progress [progress=");
        builder.append(progress);
        builder.append(", total=");
        builder.append(total);
        builder.append("]");
        return builder.toString();
    }
}
