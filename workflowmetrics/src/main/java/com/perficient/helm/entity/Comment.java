/*
 * package com.dtcc.workflowmetrics.entity;
 * 
 * import java.io.Serializable; import java.util.ArrayList; import
 * java.util.Date;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.OneToOne; import
 * javax.persistence.Table;
 * 
 * import com.fasterxml.jackson.annotation.JsonBackReference;
 * 
 * @Entity(name = "comment")
 * 
 * @Table(name = "Comment") public class Comment implements Serializable {
 *//**
	* 
	*//*
		 * private static final long serialVersionUID = 1L;
		 * 
		 * @Id
		 * 
		 * @GeneratedValue(strategy = GenerationType.AUTO) private Integer commentId;
		 * 
		 * @JsonBackReference
		 * 
		 * @OneToOne(cascade = CascadeType.MERGE)
		 * 
		 * @JoinColumn(name = "IssueID", referencedColumnName = "IssueID") private Issue
		 * issue;
		 * 
		 * @Column(name = "IssueID", insertable = false, updatable = false) private
		 * Integer issueID;
		 * 
		 * @Column(name = "CommentDetails") private ArrayList<String> commentDetails;
		 * 
		 * @Column(name = "CreationDateTime") private Date creationDateTime;
		 * 
		 * @JsonBackReference
		 * 
		 * @OneToOne(cascade = CascadeType.MERGE)
		 * 
		 * @JoinColumn(name = "UserID", referencedColumnName = "UserID") private
		 * UserDetail userDetail;
		 * 
		 * @Column(name = "UserID", insertable = false, updatable = false) private int
		 * userId;
		 * 
		 * public Integer getCommentId() { return commentId; }
		 * 
		 * public void setCommentId(Integer commentId) { this.commentId = commentId; }
		 * 
		 * public Issue getIssue() { return issue; }
		 * 
		 * public void setIssue(Issue issue) { this.issue = issue; }
		 * 
		 * public Date getCreationDateTime() { return creationDateTime; }
		 * 
		 * public void setCreationDateTime(Date creationDateTime) {
		 * this.creationDateTime = creationDateTime; }
		 * 
		 * public UserDetail getUserDetail() { return userDetail; }
		 * 
		 * public void setUserDetail(UserDetail userDetail) { this.userDetail =
		 * userDetail; }
		 * 
		 * public static long getSerialversionuid() { return serialVersionUID; }
		 * 
		 * public void setUserId(int userId) { this.userId = userId; }
		 * 
		 * public Integer getIssueID() { return issueID; }
		 * 
		 * public void setIssueID(Integer issueID) { this.issueID = issueID; }
		 * 
		 * public Integer getUserId() { return userId; }
		 * 
		 * public void setUserId(Integer userId) { this.userId = userId; }
		 * 
		 * public ArrayList<String> getCommentDetails() { return commentDetails; }
		 * 
		 * public void setCommentDetails(ArrayList<String> commentDetails) {
		 * this.commentDetails = commentDetails; }
		 * 
		 * public Date getDateTime() { return creationDateTime; }
		 * 
		 * public void setDateTime(Date dateTime) { this.creationDateTime = dateTime; }
		 * 
		 * public Comment(Integer issueID, Integer userId, ArrayList<String>
		 * commentDetails, Date dateTime) { super(); this.issueID = issueID; this.userId
		 * = userId; this.commentDetails = commentDetails; this.creationDateTime =
		 * dateTime; }
		 * 
		 * public Comment() { }
		 * 
		 * }
		 */