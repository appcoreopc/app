package com.appCore.Reporting;

/*
 * 0 - Ok  
 * 1 - Column/Field mismatch
 * 2 - Query issue 
 */


public interface ReportExecutable {
	
	int getReportState(Integer reportId);
	
	int executeRepoprt(Integer repoprtId);
}
