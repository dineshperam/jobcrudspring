package com.myproj.JobCrud.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class JobApplication {
   public JobApplication() {
		
	}

public JobApplication(Long id, String companyName, String jobTitle, Date applicationDate, String status, String notes,
		User user) {
	super();
	this.id = id;
	this.companyName = companyName;
	this.jobTitle = jobTitle;
	this.applicationDate = applicationDate;
	this.status = status;
	this.notes = notes;
	this.user = user;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getJobTitle() {
	return jobTitle;
}

public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}

public Date getApplicationDate() {
	return applicationDate;
}

public void setApplicationDate(Date applicationDate) {
	this.applicationDate = applicationDate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String companyName;
   private String jobTitle;
   
   @Temporal(TemporalType.DATE)
   private Date applicationDate;
   
   private String status; // applied, interview, offer, rejected
   
   @Column(length = 2000)
   private String notes;
   
   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)
   private User user;
   
   // Getters and Setters
}
