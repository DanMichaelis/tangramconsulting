package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.EventUser;

public interface EventUserDao extends CrudRepository<EventUser, Integer>  {

}
