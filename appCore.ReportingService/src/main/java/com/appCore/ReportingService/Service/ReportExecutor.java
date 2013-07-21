package com.appCore.reportingService.Service;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.Scripting.GroovyScriptProvider;
import com.appCore.reportingService.Core.RunnableReport;
import com.appCore.reportingService.Entity.Report;
import com.appCore.reportingService.Entity.ReportRequest;
import com.appCore.reportingService.Service.ReportExecutionResult;
import com.appCore.reportingService.Service.ReportExecutionStateConst;

@Service("reportExecutor")
@Transactional
public class ReportExecutor {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public ReportExecutionResult executeReport(ReportRequest reportRequest) throws IOException, InstantiationException, IllegalAccessException {

		ReportExecutionResult reportExecutionResult = new ReportExecutionResult();
		reportExecutionResult.setReportStatus(ReportExecutionStateConst.ReportExecuteError);
		
		Session session = sessionFactory.getCurrentSession();
		Report report = (Report) session.get(Report.class, reportRequest.getReportId());

		if (report != null) {

			String pathToScriptName = report.getReportScript();
			GroovyScriptProvider scripting = new GroovyScriptProvider();
			RunnableReport rpt = scripting.createInstance(pathToScriptName);
			
			int reportState = rpt.getReportStatus();
			
			if (reportState == ReportExecutionStateConst.ReportExecuteOk)
			{
				ReportExecutionResult status = rpt.executeReport();
			}
		}

		return reportExecutionResult;
	}

	int executeReport(RunnableReport report) {

		// if status report is non-negative //
		report.getReportStatus();

		//
		report.executeReport();

		// else return the status accordingly

		return 0;
	}

}
