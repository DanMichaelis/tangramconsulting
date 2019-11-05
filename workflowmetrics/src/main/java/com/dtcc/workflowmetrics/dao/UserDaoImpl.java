package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.UserDetail;

@Repository
public class UserDaoImpl implements UserDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addUser(UserDetail user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();

	}

	@Override
	public void getUserById(Integer userId) {
		// TODO Auto-generated method stub

	}

}
