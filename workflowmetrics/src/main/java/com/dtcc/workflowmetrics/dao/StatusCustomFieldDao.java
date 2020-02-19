package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.StatusCustomField;
import com.dtcc.workflowmetrics.entity.StatusCustomFieldId;

public interface StatusCustomFieldDao extends CrudRepository<StatusCustomField, StatusCustomFieldId>{

}
