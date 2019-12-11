package com.dtcc.workflowmetrics.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.dtcc.workflowmetrics.exception.MetricsLogicException;

@Entity(name = "project")
@Table(name = "Project")
@IdClass(ProjectId.class)
public class Project {

    @Id
    private String id;

    @Id
    private int sourceSystemId;

    @Column
    private String key;

    @Column
    private String name;

    @Column
    private long last_update_date;

    private ArrayList<ProjectCustomField> projectCustomFields;

    @Column
    private String checksum;

    private Project(Project p) {
        this.id = p.getId();
        this.key = p.getKey();
        this.last_update_date = p.getLast_update_date();
        this.name = p.getName();
        this.sourceSystemId = p.getSourceSystemId();
        projectCustomFields = new ArrayList<ProjectCustomField>();
        for (ProjectCustomField cf : p.getProjectCustomFields()) {
            projectCustomFields.add(cf.clone());
        }
    }

    public Project(String id, int sourceSystemId, String key, String name, long last_update_date,
            ArrayList<ProjectCustomField> projectCustomFields, String checksum) {
        super();
        this.id = id;
        this.sourceSystemId = sourceSystemId;
        this.key = key;
        this.name = name;
        this.last_update_date = last_update_date;
        this.projectCustomFields = projectCustomFields;
        this.checksum = calculateChecksum();
    }

    public Project(String id, int sourceSystemId, String key, String name, long last_update_date,
            ArrayList<ProjectCustomField> projectCustomFields) {
        super();
        this.id = id;
        this.sourceSystemId = sourceSystemId;
        this.key = key;
        this.name = name;
        this.last_update_date = last_update_date;
        this.projectCustomFields = projectCustomFields;
        this.checksum = calculateChecksum();
    }

    public Project() {

    }

    public final String getId() {
        return id;
    }

    public final Project setId(String id) {
        this.id = id;

        return this;
    }

    public final int getSourceSystemId() {
        return sourceSystemId;
    }

    public final Project setSourceSystemId(int sourceSystemId) {
        this.sourceSystemId = sourceSystemId;

        return this;
    }

    public final String getKey() {
        return key;
    }

    public final Project setKey(String key) {
        this.key = key;

        return this;
    }

    public final String getName() {
        return name;
    }

    public final Project setName(String name) {
        this.name = name;

        return this;
    }

    public final long getLast_update_date() {
        return last_update_date;
    }

    public final Project setLast_update_date(long last_update_date) {
        this.last_update_date = last_update_date;

        return this;
    }

    public final ArrayList<ProjectCustomField> getProjectCustomFields() {
        return projectCustomFields;
    }

    public final Project setProjectCustomFields(ArrayList<ProjectCustomField> projectCustomFields) {
        this.projectCustomFields = projectCustomFields;

        return this;
    }

    public final String getChecksum() {
        return checksum;
    }

    public final Project setChecksum(String checksum) {
        this.checksum = checksum;

        return this;
    }

    private String calculateChecksum() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.toStringWithoutCustomFieldsAndLastUpdateDate());

        for (ProjectCustomField f : projectCustomFields) {
            sb.append(f.toStringWithoutCreateDate());
        }
        return ChecksumUtil.getChecksum(sb.toString());
    }

    public ArrayList<ProjectCustomField> addCustomField(ProjectCustomField field) {

        if (null == projectCustomFields) {
            projectCustomFields = new ArrayList<ProjectCustomField>();
        }

        if (null != field) {
            if (!(field.getProjectId().equals(this.getId()))) {
                throw new MetricsLogicException("The field " + field.toString()
                        + " does not appear to be associated with project " + this.getName());
            } else {
                Boolean fieldPresent = false;
                for (ProjectCustomField f : projectCustomFields) {
                    if (f.getFieldName().equals(field.getFieldName())) {
                        fieldPresent = true;
                        f.setFieldValue(field.getFieldValue());
                    }
                }

                if (!fieldPresent) {
                    projectCustomFields.add(field);
                }
            }
        }

        return projectCustomFields;
    }

    public String toStringWithoutCustomFieldsAndLastUpdateDate() {
        StringBuilder builder = new StringBuilder();
        builder.append("Project [id=");
        builder.append(id);
        builder.append(", sourceSystemId=");
        builder.append(sourceSystemId);
        builder.append(", key=");
        builder.append(key);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Project [id=");
        builder.append(id);
        builder.append(", sourceSystemId=");
        builder.append(sourceSystemId);
        builder.append(", key=");
        builder.append(key);
        builder.append(", name=");
        builder.append(name);
        builder.append(", last_update_date=");
        builder.append(last_update_date);
        builder.append(", projectCustomFields=");
        builder.append(projectCustomFields);
        builder.append(", checksum=");
        builder.append(checksum);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((checksum == null) ? 0 : checksum.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + (int) (last_update_date ^ (last_update_date >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((projectCustomFields == null) ? 0 : projectCustomFields.hashCode());
        result = prime * result + sourceSystemId;
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
        Project other = (Project) obj;
        if (checksum == null) {
            if (other.checksum != null) {
                return false;
            }
        } else if (!checksum.equals(other.checksum)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        if (last_update_date != other.last_update_date) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (projectCustomFields == null) {
            if (other.projectCustomFields != null) {
                return false;
            }
        } else if (!projectCustomFields.equals(other.projectCustomFields)) {
            return false;
        }
        if (sourceSystemId != other.sourceSystemId) {
            return false;
        }
        return true;
    }
    
    public Project clone() {
        return new Project(this);
    }
}
