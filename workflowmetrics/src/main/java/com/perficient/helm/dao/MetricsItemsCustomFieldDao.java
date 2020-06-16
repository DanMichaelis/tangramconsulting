package com.perficient.helm.dao;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.MetricsItemsCustomField;
import com.perficient.helm.entity.MetricsItemsCustomFieldId;

public interface MetricsItemsCustomFieldDao extends CrudRepository<MetricsItemsCustomField, MetricsItemsCustomFieldId>{

}
