package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItems;
import com.dtcc.workflowmetrics.entity.MetricsItemsId;

public interface MetricsItemsDao extends CrudRepository<MetricsItems, MetricsItemsId> {

	boolean existsMetricsItemsByCheckSum(String checksum) ;

}
