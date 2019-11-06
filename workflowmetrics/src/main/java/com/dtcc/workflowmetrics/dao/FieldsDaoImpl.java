package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.Fields;

@Repository
public class FieldsDaoImpl implements FieldsDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addFieldDetails(Fields fields) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(fields);
		transaction.commit();
		session.close();

	}

	@Override
	public void getFieldById(Integer issueId) {
		// TODO Auto-generated method stub

	}

}
