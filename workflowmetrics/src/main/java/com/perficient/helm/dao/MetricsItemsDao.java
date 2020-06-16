package com.perficient.helm.dao;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.MetricsItems;
import com.perficient.helm.entity.MetricsItemsId;

public interface MetricsItemsDao extends CrudRepository<MetricsItems, MetricsItemsId> {

	boolean existsMetricsItemsByCheckSum(String checksum) ;

}
