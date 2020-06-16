package com.perficient.helm.dao;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.EventUser;
import com.perficient.helm.entity.EventUserId;

public interface EventUserDao extends CrudRepository<EventUser, EventUserId>  {

	boolean existsEventUserByCheckSum(String checksum) ;
	
}
