package com.appCore.reportingService.Service;

import java.io.Serializable;

public class ReportExecutionResult implements Serializable {

	private int ReportStatus; 
	
	private String ReportOutputPath;

	public int getReportStatus() {
		return ReportStatus;
	}

	public void setReportStatus(int reportStatus) {
		ReportStatus = reportStatus;
	}

	public String getReportOutputPath() {
		return ReportOutputPath;
	}

	public void setReportOutputPath(String reportOutputPath) {
		ReportOutputPath = reportOutputPath;
	}
	
}
