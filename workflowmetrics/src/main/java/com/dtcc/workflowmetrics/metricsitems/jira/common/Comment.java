package com.dtcc.workflowmetrics.metricsitems.jira.common;

public class Comment {
    private String self;
    private Integer id;
    private User author;
    private String body;
    private User updateAuthor;
    private String created;
    private String updated;
    
    public String getSelf() {
        return self;
    }
    public Comment setSelf(String self) {
        this.self = self;
    
        return this;
    }
    public Integer getId() {
        return id;
    }
    public Comment setId(Integer id) {
        this.id = id;
    
        return this;
    }
    public User getAuthor() {
        return author;
    }
    public Comment setAuthor(User author) {
        this.author = author;
    
        return this;
    }
    public String getBody() {
        return body;
    }
    public Comment setBody(String body) {
        this.body = body;
    
        return this;
    }
    public User getUpdateAuthor() {
        return updateAuthor;
    }
    public Comment setUpdateAuthor(User updateAuthor) {
        this.updateAuthor = updateAuthor;
    
        return this;
    }
    public String getCreated() {
        return created;
    }
    public Comment setCreated(String created) {
        this.created = created;
    
        return this;
    }
    public String getUpdated() {
        return updated;
    }
    public Comment setUpdated(String updated) {
        this.updated = updated;
    
        return this;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((self == null) ? 0 : self.hashCode());
        result = prime * result + ((updateAuthor == null) ? 0 : updateAuthor.hashCode());
        result = prime * result + ((updated == null) ? 0 : updated.hashCode());
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
        Comment other = (Comment) obj;
        if (author == null) {
            if (other.author != null) {
                return false;
            }
        } else if (!author.equals(other.author)) {
            return false;
        }
        if (body == null) {
            if (other.body != null) {
                return false;
            }
        } else if (!body.equals(other.body)) {
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
        if (self == null) {
            if (other.self != null) {
                return false;
            }
        } else if (!self.equals(other.self)) {
            return false;
        }
        if (updateAuthor == null) {
            if (other.updateAuthor != null) {
                return false;
            }
        } else if (!updateAuthor.equals(other.updateAuthor)) {
            return false;
        }
        if (updated == null) {
            if (other.updated != null) {
                return false;
            }
        } else if (!updated.equals(other.updated)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comments [self=");
        builder.append(self);
        builder.append(", id=");
        builder.append(id);
        builder.append(", author=");
        builder.append(author);
        builder.append(", body=");
        builder.append(body);
        builder.append(", updateAuthor=");
        builder.append(updateAuthor);
        builder.append(", created=");
        builder.append(created);
        builder.append(", updated=");
        builder.append(updated);
        builder.append("]");
        return builder.toString();
    }    
}
