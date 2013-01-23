package com.appCore.personnel.Core.Job.Controller;

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

import com.appCore.personnel.Core.Job.Entity.JobSetupQualification;

import com.appCore.personnel.Core.Job.Service.JobSetupQualificationService;


@Controller
@RequestMapping("/Job")
public class JobSetupQualificationController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="jobSetupQualificationService")
		private JobSetupQualificationService service;

		@RequestMapping(value = "/JobSetupQualification/list", method = RequestMethod.GET)		
		public @ResponseBody List<JobSetupQualification> listJobSetupQualification () 
		{
				List<JobSetupQualification> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/JobSetupQualification/listByJobSetup", method = RequestMethod.GET)		
		public @ResponseBody List<JobSetupQualification> listByJobSetup (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<JobSetupQualification> list = service.listByJobSetup(id);
				return list;
		}
		

		@RequestMapping(value = "/JobSetupQualification/get", method = RequestMethod.GET)		
		public @ResponseBody JobSetupQualification getJobSetupQualification (@RequestParam(value="id", required=true) Integer id ) 
		{
				JobSetupQualification jobSetupQualification=service.get(id);
				return jobSetupQualification;
		}

		@RequestMapping(value = "/JobSetupQualification/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddJobSetupQualification (@RequestBody JobSetupQualification jobSetupQualification)
		{
				service.add(jobSetupQualification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupQualification/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addJobSetupQualification (@RequestBody JobSetupQualification jobSetupQualification)
		{
				service.add(jobSetupQualification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupQualification/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateJobSetupQualification (@RequestBody JobSetupQualification jobSetupQualification)
		{
				service.saveOrUpdate(jobSetupQualification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupQualification/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteJobSetupQualification (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}