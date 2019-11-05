package com.dtcc.workflowmetrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dtcc.workflowmetrics.pojo.ProjectDetails;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	
	private SessionFactory sessionFactory;

	@Override
	public void addProject(ProjectDetails project) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(project);
		transaction.commit();
		session.close();

	}

	@Override
	public void getProjectById(Integer projectId) {
		// TODO Auto-generated method stub

	}

}
