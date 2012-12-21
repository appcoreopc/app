package com.appCore.personnel.Core.Entity;

import java.io.Serializable;
import java.util.List;

public class DivisionSummary implements Serializable 
{
	
	private Long count;
	
	private List<Division> listDivision;
	
	public Long getCount() { 
		return this.count;
	}

	public void setCount(Long count) { 
		this.count = count;
	}
	
	public List<Division> getListDivision () 
	{
		return this.listDivision;
	}

	public void setListDivision (List<Division> list) 
	{
		this.listDivision = list;
	}

}
