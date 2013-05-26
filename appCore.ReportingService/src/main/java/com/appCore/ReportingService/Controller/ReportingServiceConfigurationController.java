package com.appCore.reportingService.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import com.appCore.Requests.RequestStatus;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.reportingService.Entity.ReportingServiceConfiguration;
import com.appCore.reportingService.Service.ReportingServiceConfigurationService;

@Controller
@RequestMapping("/reportingService")
public class ReportingServiceConfigurationController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="reportingServiceConfigurationService")
		private ReportingServiceConfigurationService service;

		@RequestMapping(value = "/ReportingServiceConfiguration/list", method = RequestMethod.GET)		
		public @ResponseBody List<ReportingServiceConfiguration> listReportingServiceConfiguration () 
		{
				List<ReportingServiceConfiguration> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/ReportingServiceConfiguration/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<ReportingServiceConfiguration> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<ReportingServiceConfiguration> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/ReportingServiceConfiguration/get", method = RequestMethod.GET)		
		public @ResponseBody ReportingServiceConfiguration getReportingServiceConfiguration (@RequestParam(value="id", required=true) Integer id ) 
		{
				ReportingServiceConfiguration reportingServiceConfiguration=service.get(id);
				return reportingServiceConfiguration;
		}

		@RequestMapping(value = "/ReportingServiceConfiguration/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddReportingServiceConfiguration (@RequestBody ReportingServiceConfiguration reportingServiceConfiguration)
		{
				service.add(reportingServiceConfiguration);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ReportingServiceConfiguration/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addReportingServiceConfiguration (@RequestBody ReportingServiceConfiguration reportingServiceConfiguration)
		{
				service.add(reportingServiceConfiguration);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ReportingServiceConfiguration/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateReportingServiceConfiguration (@RequestBody ReportingServiceConfiguration reportingServiceConfiguration)
		{
				service.saveOrUpdate(reportingServiceConfiguration);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ReportingServiceConfiguration/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteReportingServiceConfiguration (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}