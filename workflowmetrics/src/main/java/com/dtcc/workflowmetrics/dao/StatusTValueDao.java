package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.StatusTValue;
import com.dtcc.workflowmetrics.entity.StatusTValueId;

public interface StatusTValueDao extends CrudRepository<StatusTValue, StatusTValueId>{

}
