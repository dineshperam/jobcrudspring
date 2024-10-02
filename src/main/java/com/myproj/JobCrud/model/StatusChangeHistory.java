package com.myproj.JobCrud.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class StatusChangeHistory {
@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String oldStatus;
   private String newStatus;
   
   @Temporal(TemporalType.TIMESTAMP)
   private Date changeDate;
   
   @ManyToOne
   @JoinColumn(name = "job_application_id")
   private JobApplication jobApplication;
   
   // Getters and Setters
   public StatusChangeHistory() {
		
	}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getOldStatus() {
	return oldStatus;
}

public void setOldStatus(String oldStatus) {
	this.oldStatus = oldStatus;
}

public String getNewStatus() {
	return newStatus;
}

public void setNewStatus(String newStatus) {
	this.newStatus = newStatus;
}

public Date getChangeDate() {
	return changeDate;
}

public void setChangeDate(Date changeDate) {
	this.changeDate = changeDate;
}

public JobApplication getJobApplication() {
	return jobApplication;
}

public void setJobApplication(JobApplication jobApplication) {
	this.jobApplication = jobApplication;
}

public StatusChangeHistory(Long id, String oldStatus, String newStatus, Date changeDate,
		JobApplication jobApplication) {
	super();
	this.id = id;
	this.oldStatus = oldStatus;
	this.newStatus = newStatus;
	this.changeDate = changeDate;
	this.jobApplication = jobApplication;
}
}
