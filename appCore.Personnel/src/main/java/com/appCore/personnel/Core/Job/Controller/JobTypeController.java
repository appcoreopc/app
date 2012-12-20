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
import com.appCore.personnel.Core.Job.Entity.JobType;

import com.appCore.personnel.Core.Job.Service.JobTypeService;


@Controller
@RequestMapping("/Job")
public class JobTypeController
{ 
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="jobTypeService")
		private JobTypeService service;

		@RequestMapping(value = "/JobType/list", method = RequestMethod.GET)		
		public @ResponseBody List<JobType> listJobType () 
		{
				List<JobType> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/JobType/get", method = RequestMethod.GET)		
		public @ResponseBody JobType getJobType (@RequestParam(value="id", required=true) Integer id) 
		{
				JobType jobType=service.get(id);
				return jobType;
		}
		
		@RequestMapping(value = "/JobType/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addJobType (@RequestBody JobType jobType)
		{
				service.add(jobType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobType/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateJobType (@RequestBody JobType jobType)
		{
				service.saveOrUpdate(jobType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/JobType/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteJobType (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
		
}