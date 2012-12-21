package com.appCore.personnel.Core.Entity;

import java.io.Serializable;
import java.util.List;

public class CompanyEntity implements Serializable 
{
	
	public String text; 
	
	public List<CompanyEntity> items; 
	
	public String type; 
	
	public String getText() 
	{ 
		return this.text;
	}

	public void setText(String text) 
	{ 
		this.text = text;
	}
	
	public String getType() 
	{ 
		return this.type;
	}

	public void setType(String type) 
	{ 
		this.type = type;
	}
	
	public List<CompanyEntity> getItems() 
	{ 
		return this.items;
	}

	public void setItems(List<CompanyEntity> items) 
	{ 
		this.items = items;
	}
		
}
