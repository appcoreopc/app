package com.appCore.personnel.User.Entity;

import java.io.Serializable;

public class UserLandingRequest implements Serializable{

	private Integer userId; 
	
	private Integer applicationType;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(Integer applicationType) {
		this.applicationType = applicationType;
	}
	
}
