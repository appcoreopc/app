package com.appCore.Requests;

import java.io.Serializable;
	
public class RequestStatus implements Serializable {
	

	private int messageCode;
	
	private String messageDescription; 
	
	public Integer getMessageCode() { 
		return this.messageCode;
	}

	public void setMessageCode(Integer messageCode) { 
		this.messageCode = messageCode;
	}
	
	
	
	public String getMessageDescription() { 
		return this.messageDescription;
	}

	public void setMessageDescription(String messageDescription) { 
		this.messageDescription = messageDescription;
	}
	
}



