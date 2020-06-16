package com.perficient.helm.entity.internal;

import java.util.Date;

/**
 * The Interface WorkItemStatus.
 */
public interface WorkItemStatus {
    

    /**
     * Gets the Source System generated ID associated with this {@link WorkItemStatus}
     *
     * @return the id
     */
    public String getId();
    
    /**
     * Sets the Source System generated ID associated with this {@link WorkItemStatus}
     *
     * @param id the Source System generated ID associated with this {@link WorkItemStatus}
     * @return the updated {@link WorkItemStatus}
     */
    public WorkItemStatus setId(String id);    
    
    /**
     * Gets the status name
     *
     * @return the status name
     */
    public String getName();
    
    /**
     * Sets the status name.
     *
     * @param name status name
     * @@return the updated {@link WorkItemStatus}
     */
    public WorkItemStatus setName(String name);
    
    /**
     * Gets the status description (if any, beyond the status name; otherwise, returns the status name)
     *
     * @return the status description or status name, if description is null
     */
    public String getDescription();
    
    /**
     * Sets the description.
     *
     * @param description the description
     * @return the updated {@link WorkItemStatus}
     */
    public WorkItemStatus setDescription(String description);
    
    /**
     * Gets the date that the record in the HELM system was updated, not the date that the record was updated in the source system
     *
     * @return the date that the record in the HELM system was updated
     */
    public Date getLastUpdateDate();
    
    /**
     * Sets the last update date for this record in the HELM system, not the date that the record was updated in the source system
     *
     * @param lastUpdateDate the date that this record was last updated
     * @return the updated {@link WorkItemStatus}
     */
    public WorkItemStatus setLastUpdateDate(Date lastUpdateDate);
    
    /**
     * Sets the last update date for this record to the current date/time
     *
     * @return the updated {@link WorkItemStatus}
     */
    public WorkItemStatus setLastUpdateDate();
    
    /**
     * Gets the {@link com.perficient.helm.entity.internal.SourceSystem} where this status originated
     * @return the {@link SourceSystem} that created this status
     */
    public SourceSystem getSourceSystem();
    
  /**
   * Associates this status with the {@link SourceSystem} that originated it
   * @param sourceSystem {@link SourceSystem} that created this status
   * @return the updated {@link WorkItemStatus}
   */
    public WorkItemStatus setSourceSystem(SourceSystem sourceSystem);
    
    /**
     * Gets the date from the source system that the status was last updated (which may be on creation).  If this is unknown or unknowable, this date may be null.
     * @return date from the source system that the status was last updated     
     */
    public Date getSourceSystemUpdateDate();
    
    /**
     * Sets the date that the status was last updated in the source system.
     * @param updateDate
     * @return the updated {@link WorkItemStatus}
     */
    public WorkItemStatus setSourceSystemUpdateDate(Date updateDate);
}
