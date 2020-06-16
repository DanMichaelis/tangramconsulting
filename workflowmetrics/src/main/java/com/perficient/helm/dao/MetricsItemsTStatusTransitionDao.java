package com.perficient.helm.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.MetricsItemsTStatusTransition;
import com.perficient.helm.entity.MetricsItemsTStatusTransitionId;

public interface MetricsItemsTStatusTransitionDao extends CrudRepository<MetricsItemsTStatusTransition, MetricsItemsTStatusTransitionId>{

	List<MetricsItemsTStatusTransition> findByItemIdAndStatusOrderByTransitionDateDesc(String itemId, int status);

}
