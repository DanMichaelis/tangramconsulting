package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.IssueLink;

@Repository
public class IssueLinkImpl implements IssueLinkDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addIssueLink(IssueLink issueLink) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(issueLink);
		transaction.commit();
		session.close();

	}

	@Override
	public void getIssueLinkById(Integer issueId) {
		// TODO Auto-generated method stub

	}

}
