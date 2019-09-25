package com.dtcc.workflowmetrics.metricsitems;

import java.util.ArrayList;

public class History {
    private Integer id;
    private Author author;
    private String created;
    private ArrayList<Item> items;
    public Integer getId() {
        return id;
    }
    public History setId(Integer id) {
        this.id = id;
    
        return this;
    }
    public Author getAuthor() {
        return author;
    }
    public History setAuthor(Author author) {
        this.author = author;
    
        return this;
    }
    public String getCreated() {
        return created;
    }
    public History setCreated(String created) {
        this.created = created;
    
        return this;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public History setItems(ArrayList<Item> items) {
        this.items = items;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
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
        History other = (History) obj;
        if (author == null) {
            if (other.author != null) {
                return false;
            }
        } else if (!author.equals(other.author)) {
            return false;
        }
        if (created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!created.equals(other.created)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (items == null) {
            if (other.items != null) {
                return false;
            }
        } else if (!items.equals(other.items)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Histories [id=");
        builder.append(id);
        builder.append(", author=");
        builder.append(author);
        builder.append(", created=");
        builder.append(created);
        builder.append(", items=[");
        builder.append(String.join(",", (String[]) items.toArray()));
        builder.append("]");
        return builder.toString();
    }
}
