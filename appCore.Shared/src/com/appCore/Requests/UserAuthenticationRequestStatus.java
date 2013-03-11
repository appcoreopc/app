package com.appCore.Requests;

public class UserAuthenticationRequestStatus extends RequestStatus {
	
	private String employeeRole; 
	
	private String username; 
	
	private String landingPage; 

	
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

	public String getLandingPage() {
		return landingPage;
	}

	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}

}
