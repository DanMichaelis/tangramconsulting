package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusDurationId;

public interface MetricsItemsStatusDurationDao extends CrudRepository<MetricsItemsStatusDuration, MetricsItemsStatusDurationId>{

}
