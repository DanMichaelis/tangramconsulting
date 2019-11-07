package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.ProjectDetails;

public interface ProjectDao extends CrudRepository<ProjectDetails, Integer>{

}
