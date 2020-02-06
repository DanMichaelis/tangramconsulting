package com.dtcc.workflowmetrics.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransitionId;

public interface MetricsItemsStatusTransitionDao extends CrudRepository<MetricsItemsStatusTransition, MetricsItemsStatusTransitionId>{

	Optional<MetricsItemsStatusTransition> findByItemIdAndProjectIdAndSourceSystemIdAndToStatus(String itemId, String projectId, int sourceSystemId, String toStatus);

	List<MetricsItemsStatusTransition> findByOrderByTransitionDateDesc();
	
}
