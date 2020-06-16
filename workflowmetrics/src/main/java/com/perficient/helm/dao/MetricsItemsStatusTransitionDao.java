package com.perficient.helm.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.MetricsItemsStatusTransition;
import com.perficient.helm.entity.MetricsItemsStatusTransitionId;

public interface MetricsItemsStatusTransitionDao extends CrudRepository<MetricsItemsStatusTransition, MetricsItemsStatusTransitionId>{

	List<MetricsItemsStatusTransition> findByItemIdAndToStatusOrderByTransitionDateDesc(String itemId, String toStatus);

	List<MetricsItemsStatusTransition> findByItemIdAndFromStatusOrderByTransitionDateAsc(String itemId, String fromStatus);

}
