package com.dtcc.workflowmetrics.metricsitems.jira;

public class SimpleLink {
    private String id;
    private String styleClass;
    private String iconClass;
    private String label;
    private String title;
    private String href;
    private Integer weight;
    public String getId() {
        return id;
    }
    public SimpleLink setId(String id) {
        this.id = id;
    
        return this;
    }
    public String getStyleClass() {
        return styleClass;
    }
    public SimpleLink setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    
        return this;
    }
    public String getIconClass() {
        return iconClass;
    }
    public SimpleLink setIconClass(String iconClass) {
        this.iconClass = iconClass;
    
        return this;
    }
    public String getLabel() {
        return label;
    }
    public SimpleLink setLabel(String label) {
        this.label = label;
    
        return this;
    }
    public String getTitle() {
        return title;
    }
    public SimpleLink setTitle(String title) {
        this.title = title;
    
        return this;
    }
    public String getHref() {
        return href;
    }
    public SimpleLink setHref(String href) {
        this.href = href;
    
        return this;
    }
    public Integer getWeight() {
        return weight;
    }
    public SimpleLink setWeight(Integer weight) {
        this.weight = weight;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((href == null) ? 0 : href.hashCode());
        result = prime * result + ((iconClass == null) ? 0 : iconClass.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((styleClass == null) ? 0 : styleClass.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        SimpleLink other = (SimpleLink) obj;
        if (href == null) {
            if (other.href != null)
                return false;
        } else if (!href.equals(other.href))
            return false;
        if (iconClass == null) {
            if (other.iconClass != null)
                return false;
        } else if (!iconClass.equals(other.iconClass))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (styleClass == null) {
            if (other.styleClass != null)
                return false;
        } else if (!styleClass.equals(other.styleClass))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
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
        return "SimpleLink [id=" + id + ", styleClass=" + styleClass + ", iconClass=" + iconClass + ", label=" + label
                + ", title=" + title + ", href=" + href + ", weight=" + weight + "]";
    }
    
    
}
