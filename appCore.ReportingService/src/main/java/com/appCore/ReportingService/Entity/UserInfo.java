package com.appCore.reportingService.Entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
	
	Integer userId;
	
	Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	
	
}
