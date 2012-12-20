package com.appCore.personnel.Core.Entity;

import java.io.Serializable;
import java.util.List;

public class DepartmentSummary  implements Serializable 
{
	
	private Long count;
	
	private List<Department> listDepartment;
	
	public Long getCount() { 
		return this.count;
	}

	public void setCount(Long count) { 
		this.count = count;
	}
	
	public List<Department> getListDepartment () 
	{
		return this.listDepartment;
	}

	public void setListDepartment (List<Department> list) 
	{
		this.listDepartment = list;
	}


}
