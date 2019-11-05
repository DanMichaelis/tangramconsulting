package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.UserDetail;

public interface UserDao {

	public void addUser(UserDetail user);
	
	public void getUserById(Integer userId);

}
