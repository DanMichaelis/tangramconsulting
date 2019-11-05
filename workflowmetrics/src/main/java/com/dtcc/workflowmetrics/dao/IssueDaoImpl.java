package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.Issue;

@Repository
public class IssueDaoImpl implements IssueDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addIssue(Issue issue) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(issue);
		transaction.commit();
		session.close();

	}

	@Override
	public void getIssueById(Integer issueId) {
		// TODO Auto-generated method stub

	}

}
