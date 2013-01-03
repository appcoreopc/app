package com.appCore.Requests;

import java.io.Serializable;

public class CodeRequest implements Serializable {
		
	private String codeName; 
	
	private int companyId;
		
	private int codeType; 

	public int getCodeType() {
		return codeType;
	}

	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	} 
	
}
