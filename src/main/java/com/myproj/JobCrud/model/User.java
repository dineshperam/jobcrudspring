package com.myproj.JobCrud.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(unique = true, nullable = false)
   private String email;
   
   private String password;
   
   private String roles;  // ROLE_USER, ROLE_ADMIN etc.

public User() {
	
}

public User(Long id, String email, String password, String roles) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.roles = roles;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRoles() {
	return roles;
}

public void setRoles(String roles) {
	this.roles = roles;
}
   
}
