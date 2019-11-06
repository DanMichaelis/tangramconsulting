package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addComment(Comment comment) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(comment);
		transaction.commit();
		session.close();

	}

	@Override
	public void getCommentById(Integer issueId) {
		// TODO Auto-generated method stub

	}

}
