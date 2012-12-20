package com.appCore.personnel.Core.Entity;

import java.io.Serializable;
import java.util.List;

public class SectionSummary implements Serializable 
{
	private Long count;
	
	private List<Section> listSection;
	
	public Long getCount() { 
		return this.count;
	}

	public void setCount(Long count) { 
		this.count = count;
	}
	
	public List<Section> getListSection () 
	{
		return this.listSection;
	}

	public void setListSection (List<Section> list) 
	{
		this.listSection = list;
	}
	
}
