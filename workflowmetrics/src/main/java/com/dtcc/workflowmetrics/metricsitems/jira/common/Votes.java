package com.dtcc.workflowmetrics.metricsitems.jira.common;

public class Votes {
    private String self;
    private String votes;
    private Boolean hasVoted;

    
	public String getSelf() {
        return self;
    }
    public Votes setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public String getVotes() {
		return votes;
	}
	public void setVotes(String votes) {
		this.votes = votes;
	}
	public Boolean getHasVoted() {
		return hasVoted;
	}
	public void setHasVoted(Boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((self == null) ? 0 : self.hashCode());
		result = prime * result + ((votes == null) ? 0 : votes.hashCode());
		result = prime * result + ((hasVoted == null) ? 0 : hasVoted.hashCode());
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
		Votes other = (Votes) obj;
		if (self == null) {
			if (other.self != null)
				return false;
		} else if (!self.equals(other.self))
			return false;
		if (votes == null) {
			if (other.votes != null)
				return false;
		} else if (!votes.equals(other.votes))
			return false;
		if (hasVoted == null) {
			if (other.hasVoted != null)
				return false;
		} else if (!hasVoted.equals(other.hasVoted))
			return false;
		return true;
	}
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Priority [self=");
        builder.append(self);
        builder.append(", votes=");
        builder.append(votes);
        builder.append(", hasVoted=");
        builder.append(hasVoted);
        builder.append("]");
        return builder.toString();
    }
}
