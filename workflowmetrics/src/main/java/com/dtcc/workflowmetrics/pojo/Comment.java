package com.dtcc.workflowmetrics.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable{
	@Id
	@Column(name = "IssueID")
	private Integer issueID;

	@Column(name = "UserId")
	private Integer userId;

	@Column(name = "CommentDetails")
	private ArrayList<String> commentDetails;

	@Column(name = "DateTime")
	private Date dateTime;

	public Integer getIssueID() {
		return issueID;
	}

	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public ArrayList<String> getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(ArrayList<String> commentDetails) {
		this.commentDetails = commentDetails;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Comment(Integer issueID, Integer userId, ArrayList<String> commentDetails, Date dateTime) {
		super();
		this.issueID = issueID;
		this.userId = userId;
		this.commentDetails = commentDetails;
		this.dateTime = dateTime;
	}

	public Comment() {
	}
	
	
}
