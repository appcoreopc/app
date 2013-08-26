package com.appCore.personnel.User.Entity;

import java.io.Serializable;
import java.util.List;

import com.appCore.personnel.Core.Entity.CompanyEntity;

public class FormMenuView implements Serializable 
{
	private String text; 
	
	private String link; 
	
	private Integer type;
	
	private List<FormMenuView> items;
	
	
	public String getText() 
	{ 
		return this.text;
	}

	public void setText(String text) 
	{ 
		this.text = text;
	}

	public String getLink() 
	{ 
		return this.link;
	}

	public void setLink(String link) 
	{ 
		this.link = link;
	}
	
	public List<FormMenuView> getItems() 
	{ 
		return this.items;
	}

	public void setItems(List<FormMenuView> items) 
	{ 
		this.items = items;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

			
}


