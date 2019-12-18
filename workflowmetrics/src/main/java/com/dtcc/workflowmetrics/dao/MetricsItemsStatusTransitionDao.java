package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransitionId;

public interface MetricsItemsStatusTransitionDao extends CrudRepository<MetricsItemsStatusTransition, MetricsItemsStatusTransitionId>{

}
