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
@Table(name="tasks")
public class Task {
	@Id 
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private String status;
	
	@Temporal(TemporalType.DATE)
	  private Date startDate;

	  @Temporal(TemporalType.DATE)
	  private Date dueDate;

	  @ManyToOne
	  @JoinColumn(name = "assigned_to")
	  private User assignedUser;

	  public Task(int id, String title, String description, String status, Date startDate, Date dueDate,
			User assignedUser) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.assignedUser = assignedUser;
	  }

	  public int getId() {
		  return id;
	  }

	  public void setId(int id) {
		  this.id = id;
	  }

	  public String getTitle() {
		  return title;
	  }

	  public void setTitle(String title) {
		  this.title = title;
	  }

	  public String getDescription() {
		  return description;
	  }

	  public void setDescription(String description) {
		  this.description = description;
	  }

	  public String getStatus() {
		  return status;
	  }

	  public void setStatus(String status) {
		  this.status = status;
	  }

	  public Date getStartDate() {
		  return startDate;
	  }

	  public void setStartDate(Date startDate) {
		  this.startDate = startDate;
	  }

	  public Date getDueDate() {
		  return dueDate;
	  }

	  public void setDueDate(Date dueDate) {
		  this.dueDate = dueDate;
	  }

	  public User getAssignedUser() {
		  return assignedUser;
	  }

	  public void setAssignedUser(User assignedUser) {
		  this.assignedUser = assignedUser;
	  }

	  // Getters and Setters
	

	

}
