package com.appCore.personnel.Core.Entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class UnitSummary implements Serializable 
{
	
	private Long count;
	
	private List<Unit> listUnit;
	
	public Long getCount() { 
		return this.count;
	}

	public void setCount(Long count) { 
		this.count = count;
	}
	
	public List<Unit> getListUnit () 
	{
		return this.listUnit;
	}

	public void setListUnit (List<Unit> list) 
	{
		this.listUnit = list;
	}
	
}
