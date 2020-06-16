package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.MetricsItemsCustomField;
import com.dtcc.workflowmetrics.entity.MetricsItemsCustomFieldId;

public interface MetricsItemsCustomFieldDao extends CrudRepository<MetricsItemsCustomField, MetricsItemsCustomFieldId>{

}
