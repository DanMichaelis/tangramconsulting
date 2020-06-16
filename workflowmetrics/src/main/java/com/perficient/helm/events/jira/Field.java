package com.perficient.helm.events.jira;

import java.util.ArrayList;

public class Field {
    private String id;
    private String name;
    private JsonTypeBean schema;
    private String description;
    private String key;
    private ArrayList<ScreenID> screens;
    private ArrayList<ContextID> contexts;
    private String lastUsed;

    public String getId() {
        return id;
    }

    public Field setId(String id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return name;
    }

    public Field setName(String name) {
        this.name = name;

        return this;
    }

    public JsonTypeBean getSchema() {
        return schema;
    }

    public Field setSchema(JsonTypeBean schema) {
        this.schema = schema;

        return this;
    }

    public String getDescription() {
        return description;
    }

    public Field setDescription(String description) {
        this.description = description;

        return this;
    }

    public String getKey() {
        return key;
    }

    public Field setKey(String key) {
        this.key = key;

        return this;
    }

    public ArrayList<ScreenID> getScreens() {
        return screens;
    }

    public Field setScreens(ArrayList<ScreenID> screens) {
        this.screens = screens;

        return this;
    }

    public ArrayList<ContextID> getContexts() {
        return contexts;
    }

    public Field setContexts(ArrayList<ContextID> contexts) {
        this.contexts = contexts;

        return this;
    }

    public String getLastUsed() {
        return lastUsed;
    }

    public Field setLastUsed(String lastUsed) {
        this.lastUsed = lastUsed;

        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contexts == null) ? 0 : contexts.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((lastUsed == null) ? 0 : lastUsed.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((screens == null) ? 0 : screens.hashCode());
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
        Field other = (Field) obj;
        if (contexts == null) {
            if (other.contexts != null)
                return false;
        } else if (!contexts.equals(other.contexts))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (lastUsed == null) {
            if (other.lastUsed != null)
                return false;
        } else if (!lastUsed.equals(other.lastUsed))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (schema == null) {
            if (other.schema != null)
                return false;
        } else if (!schema.equals(other.schema))
            return false;
        if (screens == null) {
            if (other.screens != null)
                return false;
        } else if (!screens.equals(other.screens))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Field [id=" + id + ", name=" + name + ", schema=" + schema + ", description=" + description + ", key="
                + key + ", screens=" + screens + ", contexts=" + contexts + ", lastUsed=" + lastUsed + "]";
    }
    
    
}
