package com.appCore.personnel.Core.Entity;

import java.io.Serializable;
import java.util.List;

public class BranchSummary implements Serializable 
{
	
	private Long count;
	
	private List<Branch> listBranch;
	
	public Long getCount() { 
		return this.count;
	}

	public void setCount(Long count) { 
		this.count = count;
	}
	
	public List<Branch> getListBranch () 
	{
		return this.listBranch;
	}

	public void setListBranch (List<Branch> list) 
	{
		this.listBranch = list;
	}
}
