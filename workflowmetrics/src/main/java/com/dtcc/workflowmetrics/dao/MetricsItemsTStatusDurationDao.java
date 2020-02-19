package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusDurationId;

public interface MetricsItemsTStatusDurationDao extends CrudRepository<MetricsItemsTStatusDuration, MetricsItemsTStatusDurationId>{

}
