package com.app.register.model;

import java.time.LocalDateTime;

import com.app.register.pojo.UserPojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LoginHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne
    private	UserRegister user;
	
	LocalDateTime lastLoginTimeStamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserRegister getUser() {
		return user;
	}

	public void setUser(UserRegister user) {
		this.user = user;
	}

	public LocalDateTime getLastLoginTimeStamp() {
		return lastLoginTimeStamp;
	}

	public void setLastLoginTimeStamp(LocalDateTime lastLoginTimeStamp) {
		this.lastLoginTimeStamp = lastLoginTimeStamp;
	}

	public UserPojo save(Object userPojo) {
	    // TODO Auto-generated method stub
	    return null;
	  }
}

