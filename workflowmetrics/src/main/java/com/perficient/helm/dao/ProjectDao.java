package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.Project;
import com.dtcc.workflowmetrics.entity.ProjectId;

public interface ProjectDao extends CrudRepository<Project, ProjectId> {

}
