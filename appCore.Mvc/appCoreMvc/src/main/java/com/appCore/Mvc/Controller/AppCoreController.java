package com.appCore.Mvc.Controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.appCore.Requests.*;

public class AppCoreController 
{
	
	@ExceptionHandler(NullPointerException.class)
	public @ResponseBody RequestStatus handleException(Exception exception)
	{
		RequestStatus errorStatus = new RequestStatus();
		errorStatus.setMessageCode(-999);
		errorStatus.setMessageDescription(exception.getMessage());
		return errorStatus;
	}
}
