package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.Transition;

@Repository
public class TransitionDaoImpl implements TransitionDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addTransitionDetails(Transition transition) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(transition);
		transaction.commit();
		session.close();
	}

	@Override
	public void getTransitionById(Integer workflowId) {
		// TODO Auto-generated method stub

	}

}
