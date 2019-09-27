package com.dtcc.workflowmetrics.metricsitems.jira.common;

import java.util.ArrayList;
import java.util.HashMap;

public class Author {
    private String self;
    private String name;
    private String key;
    private String emailAddress;
    private HashMap<String, String> avatarUrls;
    private String displayName;
    private Boolean active;
    private String timeZone;
   
    
    public String getSelf() {
        return self;
    }
    public Author setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public String getName() {
        return name;
    }
    public Author setName(String name) {
        this.name = name;
    
        return this;
    }
    public String getKey() {
        return key;
    }
    public Author setKey(String key) {
        this.key = key;
    
        return this;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public Author setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    
        return this;
    }
    public HashMap<String, String> getAvatarUrls() {
        return avatarUrls;
    }
    public Author setAvatarUrls(HashMap<String, String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    
        return this;
    }
    public String getDisplayName() {
        return displayName;
    }
    public Author setDisplayName(String displayName) {
        this.displayName = displayName;
    
        return this;
    }
    public Boolean getActive() {
        return active;
    }
    public Author setActive(Boolean active) {
        this.active = active;
    
        return this;
    }
    public String getTimeZone() {
        return timeZone;
    }
    public Author setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    
        return this;
    }
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((avatarUrls == null) ? 0 : avatarUrls.hashCode());       
        result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
        result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((self == null) ? 0 : self.hashCode());
        result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
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
        Author other = (Author) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (avatarUrls == null) {
            if (other.avatarUrls != null)
                return false;
        } else if (!avatarUrls.equals(other.avatarUrls))
            return false;
        if (displayName == null) {
            if (other.displayName != null)
                return false;
        } else if (!displayName.equals(other.displayName))
            return false;
        if (emailAddress == null) {
            if (other.emailAddress != null)
                return false;
        } else if (!emailAddress.equals(other.emailAddress))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (self == null) {
            if (other.self != null)
                return false;
        } else if (!self.equals(other.self))
            return false;
        if (timeZone == null) {
            if (other.timeZone != null)
                return false;
        } else if (!timeZone.equals(other.timeZone))
            return false;
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Author [self=");
        builder.append(self);
        builder.append(", name=");
        builder.append(name);
        builder.append(", key=");
        builder.append(key);
        builder.append(", emailAddress=");
        builder.append(emailAddress);
        builder.append(", avatarUrls=");
        builder.append("[");
        for (String key : avatarUrls.keySet()) {
            if (!builder.substring(builder.length() - 1, builder.length()).equals("[")) {
                builder.append(", ");
            }
            builder.append(key +":" + avatarUrls.get(key));
        }
        builder.append("], ");    
        builder.append(", displayName=");
        builder.append(displayName);
        builder.append(", active=");
        builder.append(active);
        builder.append(", timeZone=");
        builder.append(timeZone);
        return builder.toString();
    }
}
