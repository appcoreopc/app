package com.appCore.reportingService.Core;

import com.appCore.reportingService.Service.ReportExecutionResult;

public interface RunnableReport {
		
	int getReportStatus(); 
	
	ReportExecutionResult executeReport();
	
}
