package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.ProjectDetails;

public interface ProjectDao {

	public void addProject(ProjectDetails project);
	
	public void getProjectById(Integer projectId);

}
