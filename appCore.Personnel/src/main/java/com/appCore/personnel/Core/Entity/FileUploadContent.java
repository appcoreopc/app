package com.appCore.personnel.Core.Entity;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadContent {
	
	private String name; 
	
	private CommonsMultipartFile file;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	} 
	
}
