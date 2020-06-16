package com.dtcc.workflowmetrics.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.Status;
import com.dtcc.workflowmetrics.entity.StatusId;

public interface StatusDao extends CrudRepository<Status, StatusId> {

	Optional<Status> findByName(String name);


}
