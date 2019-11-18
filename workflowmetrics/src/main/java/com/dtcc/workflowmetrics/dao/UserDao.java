package com.dtcc.workflowmetrics.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.UserDetail;

public interface UserDao extends CrudRepository<UserDetail, Integer>{

	Optional<UserDetail> findByEmailId(String emailId);
}
