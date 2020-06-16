package com.perficient.helm.dao;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.MetricsItemsStatusDuration;
import com.perficient.helm.entity.MetricsItemsStatusDurationId;

public interface MetricsItemsStatusDurationDao extends CrudRepository<MetricsItemsStatusDuration, MetricsItemsStatusDurationId>{

}
