package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.TStatusDuration;

@Repository
public class TStatusDurationDaoImpl implements TStatusDurationDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addTStatusDuration(TStatusDuration durationDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(durationDetails);
		transaction.commit();
		session.close();

	}

	@Override
	public void getTStatusById(Integer issueId) {
		// TODO Auto-generated method stub

	}

}
