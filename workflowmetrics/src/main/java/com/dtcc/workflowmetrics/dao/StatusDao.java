package com.dtcc.workflowmetrics.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.Status;
import com.dtcc.workflowmetrics.entity.StatusId;

public interface StatusDao extends CrudRepository<Status, StatusId> {

	boolean existsStatusByCheckSum(String checksum) ;
	
	Optional<Status> findByName(String name);


}
