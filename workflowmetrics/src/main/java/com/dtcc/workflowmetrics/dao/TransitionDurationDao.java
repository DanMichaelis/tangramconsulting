package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.TStatusDuration;

public interface TransitionDurationDao {

	public void addTStatusDuration(TStatusDuration durationDetails);
	
	public void getTStatusById(Integer issueId);


}
