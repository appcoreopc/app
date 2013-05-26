package com.appCore.reportingService.Entity;

import java.io.Serializable;
import java.util.List;

public class ReportRequest implements Serializable {

	Integer reportId; 
	
	String reportTitle;
	
	String outputFormat; 
	
	List<String> fields;
		
	String userReportName;
	
	Integer resourceId; 

	String reportLogicScript; 
	
	UserInfo userInfo;

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public String getUserReportName() {
		return userReportName;
	}

	public void setUserReportName(String userReportName) {
		this.userReportName = userReportName;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getReportLogicScript() {
		return reportLogicScript;
	}

	public void setReportLogicScript(String reportLogicScript) {
		this.reportLogicScript = reportLogicScript;
	}
	
}
