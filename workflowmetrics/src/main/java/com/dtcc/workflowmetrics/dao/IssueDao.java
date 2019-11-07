package com.dtcc.workflowmetrics.dao;

import org.springframework.data.repository.CrudRepository;

import com.dtcc.workflowmetrics.entity.Issue;

public interface IssueDao extends CrudRepository<Issue, Integer>{

}
