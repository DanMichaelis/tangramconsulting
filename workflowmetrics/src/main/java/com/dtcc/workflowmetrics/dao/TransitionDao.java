package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.Transition;

public interface TransitionDao extends CrudRepository<Transition, Integer>{


}
