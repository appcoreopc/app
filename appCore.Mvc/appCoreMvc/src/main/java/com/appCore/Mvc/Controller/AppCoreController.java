package com.appCore.Mvc.Controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import com.appCore.Requests.RequestStatus;

@ControllerAdvice
public class AppCoreController 
{			
	@ExceptionHandler(Exception.class)
	public @ResponseBody RequestStatus handleException(Exception exception)
	{
		RequestStatus errorStatus = new RequestStatus();
		errorStatus.setMessageCode(-999);
		errorStatus.setMessageDescription(exception.getMessage());
		return errorStatus;
	}	
	
}
