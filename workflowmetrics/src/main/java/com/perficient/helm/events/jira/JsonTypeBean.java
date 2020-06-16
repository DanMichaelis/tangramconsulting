package com.perficient.helm.events.jira;

public class JsonTypeBean {
    private String type;
    private String items;
    private String system;
    private String custom;
    private Integer customId;
    private Object configuration;
    public String getType() {
        return type;
    }
    public JsonTypeBean setType(String type) {
        this.type = type;
    
        return this;
    }
    public String getItems() {
        return items;
    }
    public JsonTypeBean setItems(String items) {
        this.items = items;
    
        return this;
    }
    public String getSystem() {
        return system;
    }
    public JsonTypeBean setSystem(String system) {
        this.system = system;
    
        return this;
    }
    public String getCustom() {
        return custom;
    }
    public JsonTypeBean setCustom(String custom) {
        this.custom = custom;
    
        return this;
    }
    public Integer getCustomId() {
        return customId;
    }
    public JsonTypeBean setCustomId(Integer customId) {
        this.customId = customId;
    
        return this;
    }
    public Object getConfiguration() {
        return configuration;
    }
    public JsonTypeBean setConfiguration(Object configuration) {
        this.configuration = configuration;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((configuration == null) ? 0 : configuration.hashCode());
        result = prime * result + ((custom == null) ? 0 : custom.hashCode());
        result = prime * result + ((customId == null) ? 0 : customId.hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((system == null) ? 0 : system.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        JsonTypeBean other = (JsonTypeBean) obj;
        if (configuration == null) {
            if (other.configuration != null)
                return false;
        } else if (!configuration.equals(other.configuration))
            return false;
        if (custom == null) {
            if (other.custom != null)
                return false;
        } else if (!custom.equals(other.custom))
            return false;
        if (customId == null) {
            if (other.customId != null)
                return false;
        } else if (!customId.equals(other.customId))
            return false;
        if (items == null) {
            if (other.items != null)
                return false;
        } else if (!items.equals(other.items))
            return false;
        if (system == null) {
            if (other.system != null)
                return false;
        } else if (!system.equals(other.system))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "JsonTypeBean [type=" + type + ", items=" + items + ", system=" + system + ", custom=" + custom
                + ", customId=" + customId + ", configuration=" + configuration + "]";
    } 
    
    
    
}
