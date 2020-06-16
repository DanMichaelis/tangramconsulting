package com.perficient.helm.entity.internal;

import java.util.Date;

/**
 * Represents a transition that a
 * {@link com.perficient.helm.entity.internal.WorkItem} goes through in its
 * lifecycle.
 * 
 * @author dan.michaelis Combinations of transitions make up the historical
 *             workflow for the work item associated with the transitions.
 *             Workflows are not defined as objects, because the utility
 *             addresses them historically (i.e. what happened) as opposed to
 *             predictively (i.e. what the next step is). This allows for
 *             flexibility in tracking what has happened to the item as the
 *             source system workflows change.
 *
 */
public interface WorkItemTransitionEvent {

    /**
     * Gets the status that the work item was in at the start of the transition
     * 
     * @return {@link com.perficient.helm.entity.internal.WorkItemStatus} at the
     *             transition start
     */
    public WorkItemStatus getFromStatus();

    /**
     * Gets the status that the work item was in at the end of the transition
     * 
     * @return {@link com.perficient.helm.entity.internal.WorkItemStatus} at the
     *             transition end
     */
    public WorkItemStatus getToStatus();

    /**
     * Gets the {@link com.perficient.helm.entity.internal.WorkItem} that has been
     * transitioned
     * 
     * @return the transitioned {@link com.perficient.helm.entity.internal.WorkItem}
     */
    public WorkItem getWorkItem();

    /**
     * Gets the date/time that the
     * {@link com.perficient.helm.entity.internal.WorkItemTransitionEvent} occurred
     * 
     * @return {@link java.util.Date} that the
     *             {@link com.perficient.helm.entity.internal.WorkItem} transitioned
     */
    public Date getTransitionDate();

    /**
     * Gets the {@link com.perficient.helm.entity.internal.User} that initiated the
     * transition
     * 
     * @return the {@link com.perficient.helm.entity.internal.User} that initiated
     *             the transition
     */
    public User getTransitioner();

}
