package com.appCore.Requests;

import java.io.Serializable;
	
public class RequestStatus implements Serializable {
	
	
	private int messageCode;
	
	private String messageDescription; 
	
	private int saveCode; 
	
	public int getSaveCode() {
		return saveCode;
	}

	public void setSaveCode(int saveCode) {
		this.saveCode = saveCode;
	}

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



