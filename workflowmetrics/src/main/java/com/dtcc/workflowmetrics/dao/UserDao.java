package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.UserDetail;

public interface UserDao extends CrudRepository<UserDetail, Integer>{


}
