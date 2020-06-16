package com.perficient.helm.dao;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.Project;
import com.perficient.helm.entity.ProjectId;

public interface ProjectDao extends CrudRepository<Project, ProjectId> {

}
