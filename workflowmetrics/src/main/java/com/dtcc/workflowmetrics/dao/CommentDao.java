package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.Comment;

public interface CommentDao {

	public void addComment(Comment comment);
	
	public void getCommentById(Integer issueId);

}
