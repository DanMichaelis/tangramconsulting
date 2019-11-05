package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.IssueType;

@Repository
public class IssueTypeDaoImpl implements IssueTypeDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addIssueType(IssueType issueType) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(issueType);
		transaction.commit();
		session.close();

	}

	@Override
	public void getIssueTypeById(Integer issueTypeId) {
		// TODO Auto-generated method stub

	}

}
