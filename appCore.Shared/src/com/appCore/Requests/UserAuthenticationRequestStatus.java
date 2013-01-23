package com.appCore.Requests;

public class UserAuthenticationRequestStatus extends RequestStatus {
	
	private String employeeRole; 
	
	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String username; 


}
