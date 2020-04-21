package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.EventUser;
import com.dtcc.workflowmetrics.entity.EventUserId;

public interface EventUserDao extends CrudRepository<EventUser, EventUserId>  {

	boolean existsEventUserByCheckSum(String checksum) ;
	
}
