package com.dtcc.workflowmetrics.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransitionId;

public interface MetricsItemsTStatusTransitionDao extends CrudRepository<MetricsItemsTStatusTransition, MetricsItemsTStatusTransitionId>{

	List<MetricsItemsTStatusTransition> findByItemIdAndStatusOrderByTransitionDateDesc(String itemId, int status);

}
