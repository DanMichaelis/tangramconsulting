package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.Transition;

public interface TransitionDao {

	public void addTransitionDetails(Transition transition);
	
	public void getTransitionById(Integer workflowId);


}
