package com.dtcc.workflowmetrics.util.simulator.workflows;

public class Status {

    private int minDuration;
    private int maxDuration;
    private String name;
    private final int id;
    private static int nextId = 0;
    
    public static final Status TODO = new Status("To Do", 0, 10);
    public static final Status IN_PROGRESS = new Status("In Progress", 1, 30);
    public static final Status IN_REVIEW = new Status("In Review", 1, 3);
    public static final Status IN_TEST = new Status("In Test", 1, 90);
    public static final Status CANCELLED = new Status("Cancelled", 1, Integer.MAX_VALUE);
    public static final Status DONE = new Status("Done", 1, Integer.MAX_VALUE);
    private static final Status[] statuses = new Status[] {TODO, IN_PROGRESS, IN_REVIEW, IN_TEST, CANCELLED, DONE};
    
    private Status(String name, int minDuration, int maxDuration) {
        this.name = name;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.id = nextId++;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public Status setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    
        return this;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public Status setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    
        return this;
    }

    public String getName() {
        return name;
    }

    public Status setName(String name) {
        this.name = name;
    
        return this;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maxDuration;
        result = prime * result + minDuration;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Status other = (Status) obj;
        if (maxDuration != other.maxDuration)
            return false;
        if (minDuration != other.minDuration)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public static Status getStatusByName(String currentStatus) {
        for (Status status : statuses) {
            if (status.getName().toLowerCase().contentEquals(currentStatus.toLowerCase())) {
                return status;
            }
        }
        return null;
    } 
}
