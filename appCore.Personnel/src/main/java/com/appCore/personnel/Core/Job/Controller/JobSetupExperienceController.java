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

import com.appCore.personnel.Core.Job.Entity.JobSetupExperience;

import com.appCore.personnel.Core.Job.Service.JobSetupExperienceService;


@Controller
@RequestMapping("/Job")
public class JobSetupExperienceController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="jobSetupExperienceService")
		private JobSetupExperienceService service;

		@RequestMapping(value = "/JobSetupExperience/list", method = RequestMethod.GET)		
		public @ResponseBody List<JobSetupExperience> listJobSetupExperience () 
		{
				List<JobSetupExperience> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/JobSetupExperience/listByJobSetup", method = RequestMethod.GET)		
		public @ResponseBody List<JobSetupExperience> listByJobSetup (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<JobSetupExperience> jobSetupExperience= service.listByJobSetup(id);
				return jobSetupExperience;
		}
		
		
		@RequestMapping(value = "/JobSetupExperience/get", method = RequestMethod.GET)		
		public @ResponseBody JobSetupExperience getJobSetupExperience (@RequestParam(value="id", required=true) Integer id ) 
		{
				JobSetupExperience jobSetupExperience=service.get(id);
				return jobSetupExperience;
		}

		@RequestMapping(value = "/JobSetupExperience/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddJobSetupExperience (@RequestBody JobSetupExperience jobSetupExperience)
		{
				service.add(jobSetupExperience);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupExperience/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addJobSetupExperience (@RequestBody JobSetupExperience jobSetupExperience)
		{
				service.add(jobSetupExperience);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupExperience/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateJobSetupExperience (@RequestBody JobSetupExperience jobSetupExperience)
		{
				service.saveOrUpdate(jobSetupExperience);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupExperience/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteJobSetupExperience (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}