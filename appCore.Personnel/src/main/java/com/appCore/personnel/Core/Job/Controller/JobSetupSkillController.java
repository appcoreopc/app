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
import com.appCore.personnel.Core.Job.Entity.JobSetupSkill;

import com.appCore.personnel.Core.Job.Service.JobSetupSkillService;


@Controller
@RequestMapping("/Job")
public class JobSetupSkillController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="jobSetupSkillService")
		private JobSetupSkillService service;

		@RequestMapping(value = "/JobSetupSkill/list", method = RequestMethod.GET)		
		public @ResponseBody List<JobSetupSkill> listJobSetupSkill () 
		{
				List<JobSetupSkill> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/JobSetupSkill/listByJobSetup", method = RequestMethod.GET)		
		public @ResponseBody List<JobSetupSkill> listByJobSetup (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<JobSetupSkill> list = service.listByJobSetup(id);
				return list;
		}
		
		
		@RequestMapping(value = "/JobSetupSkill/get", method = RequestMethod.GET)		
		public @ResponseBody JobSetupSkill getJobSetupSkill (@RequestParam(value="id", required=true) Integer id ) 
		{
				JobSetupSkill jobSetupSkill=service.get(id);
				return jobSetupSkill;
		}

		@RequestMapping(value = "/JobSetupSkill/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddJobSetupSkill (@RequestBody JobSetupSkill jobSetupSkill)
		{
				service.add(jobSetupSkill);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupSkill/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addJobSetupSkill (@RequestBody JobSetupSkill jobSetupSkill)
		{
				service.add(jobSetupSkill);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupSkill/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateJobSetupSkill (@RequestBody JobSetupSkill jobSetupSkill)
		{
				service.saveOrUpdate(jobSetupSkill);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobSetupSkill/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteJobSetupSkill (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}