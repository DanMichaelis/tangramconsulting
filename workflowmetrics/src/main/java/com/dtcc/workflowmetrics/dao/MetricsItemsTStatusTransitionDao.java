package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransitionId;

public interface MetricsItemsTStatusTransitionDao extends CrudRepository<MetricsItemsTStatusTransition, MetricsItemsTStatusTransitionId>{

}
