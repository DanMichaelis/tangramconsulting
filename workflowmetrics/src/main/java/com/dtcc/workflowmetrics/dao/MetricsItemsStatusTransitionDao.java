package com.dtcc.workflowmetrics.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransitionId;

public interface MetricsItemsStatusTransitionDao extends CrudRepository<MetricsItemsStatusTransition, MetricsItemsStatusTransitionId>{

	List<MetricsItemsStatusTransition> findByItemIdAndToStatusOrderByTransitionDateDesc(String itemId, String toStatus);

	List<MetricsItemsStatusTransition> findByItemIdAndFromStatusOrderByTransitionDateAsc(String itemId, String fromStatus);

}
