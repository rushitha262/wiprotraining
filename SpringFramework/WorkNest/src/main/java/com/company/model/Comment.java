package com.company.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	  @JoinColumn(name = "task_id")
	  private Task task;

	  @ManyToOne
	  @JoinColumn(name = "user_id")
	  private User user;
	  
	  private String commentText;

	  @Temporal(TemporalType.TIMESTAMP)
	  private Date timestamp;

	  public Comment(int id, Task task, User user, String commentText, Date timestamp) {
		super();
		this.id = id;
		this.task = task;
		this.user = user;
		this.commentText = commentText;
		this.timestamp = timestamp;
	  }

	  public int getId() {
		  return id;
	  }

	  public void setId(int id) {
		  this.id = id;
	  }

	  public Task getTask() {
		  return task;
	  }

	  public void setTask(Task task) {
		  this.task = task;
	  }

	  public User getUser() {
		  return user;
	  }

	  public void setUser(User user) {
		  this.user = user;
	  }

	  public String getCommentText() {
		  return commentText;
	  }

	  public void setCommentText(String commentText) {
		  this.commentText = commentText;
	  }

	  public Date getTimestamp() {
		  return timestamp;
	  }

	  public void setTimestamp(Date timestamp) {
		  this.timestamp = timestamp;
	  }
	  
	  
	  

}
