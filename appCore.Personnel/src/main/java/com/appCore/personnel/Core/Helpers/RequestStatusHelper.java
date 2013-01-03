package com.appCore.personnel.Core.Helpers;

import com.appCore.Requests.RequestStatus;

public class RequestStatusHelper {
	
	public static RequestStatus GenerateRequestStatusSaveOperation() 
	{
		RequestStatus status = new RequestStatus(); 
		status.setMessageCode(0);
		status.setMessageDescription("Save operation completed successfully.");
		return status; 
	}
	
	public static RequestStatus GenerateRequestStatusCreateOperation() 
	{
		RequestStatus status = new RequestStatus(); 
		status.setMessageCode(0);
		status.setMessageDescription("Create operation completed successfully.");
		return status; 
	}
	
	public static RequestStatus GenerateRequestStatusDeleteOperation() 
	{
		RequestStatus status = new RequestStatus(); 
		status.setMessageCode(0);
		status.setMessageDescription("Delete operation completed successfully.");
		return status; 
	}
	
	public static RequestStatus GenerateErrorMessage(String messageText, int messageCode) 
	{
		RequestStatus status = new RequestStatus(); 
		status.setMessageCode(messageCode);
		status.setMessageDescription(messageText);
		return status; 
	}
	
	
	public static RequestStatus CodeCheckStatusOk(String messageText, int messageCode) 
	{
		RequestStatus status = new RequestStatus(); 
		status.setMessageCode(messageCode);
		status.setMessageDescription(messageText);
		return status; 
	}
	
	public static RequestStatus CodeCheckStatusDuplicate(String messageText, int messageCode) 
	{
		RequestStatus status = new RequestStatus(); 
		status.setMessageCode(messageCode);
		status.setMessageDescription(messageText);
		return status; 
	}
	
}
