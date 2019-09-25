package com.dtcc.workflowmetrics.metricsitems.jira;

import java.util.ArrayList;

public class LinkGroup {
    private String id;
    private String styleClass;
    private SimpleLink header;
    private Integer weight;
    private ArrayList<SimpleLink> links;
    private ArrayList<LinkGroup> groups;
    public String getId() {
        return id;
    }
    public LinkGroup setId(String id) {
        this.id = id;
    
        return this;
    }
    public String getStyleClass() {
        return styleClass;
    }
    public LinkGroup setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    
        return this;
    }
    public SimpleLink getHeader() {
        return header;
    }
    public LinkGroup setHeader(SimpleLink header) {
        this.header = header;
    
        return this;
    }
    public Integer getWeight() {
        return weight;
    }
    public LinkGroup setWeight(Integer weight) {
        this.weight = weight;
    
        return this;
    }
    public ArrayList<SimpleLink> getLinks() {
        return links;
    }
    public LinkGroup setLinks(ArrayList<SimpleLink> links) {
        this.links = links;
    
        return this;
    }
    public ArrayList<LinkGroup> getGroups() {
        return groups;
    }
    public LinkGroup setGroups(ArrayList<LinkGroup> groups) {
        this.groups = groups;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result + ((header == null) ? 0 : header.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((links == null) ? 0 : links.hashCode());
        result = prime * result + ((styleClass == null) ? 0 : styleClass.hashCode());
        result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
        LinkGroup other = (LinkGroup) obj;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        if (header == null) {
            if (other.header != null)
                return false;
        } else if (!header.equals(other.header))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (links == null) {
            if (other.links != null)
                return false;
        } else if (!links.equals(other.links))
            return false;
        if (styleClass == null) {
            if (other.styleClass != null)
                return false;
        } else if (!styleClass.equals(other.styleClass))
            return false;
        if (weight == null) {
            if (other.weight != null)
                return false;
        } else if (!weight.equals(other.weight))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "LinkGroup [id=" + id + ", styleClass=" + styleClass + ", header=" + header + ", weight=" + weight
                + ", links=" + links + ", groups=" + groups + "]";
    }
    
    
}
