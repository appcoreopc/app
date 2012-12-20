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
import com.appCore.personnel.Core.Job.Entity.EmployeeExperience;

import com.appCore.personnel.Core.Job.Service.ExperienceService;


@Controller
@RequestMapping("/Job")
public class ExperienceController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="experienceService")
		private ExperienceService service;

		@RequestMapping(value = "/Experience/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeExperience> listExperience () 
		{
				List<EmployeeExperience> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Experience/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeExperience getExperience (@RequestParam(value="id", required=true) Integer id) 
		{
				EmployeeExperience experience=service.get(id);
				return experience;
		}

		
		@RequestMapping(value = "/Experience/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addExperience (@RequestBody EmployeeExperience experience)
		{
				service.add(experience);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Experience/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus  saveOrUpdateExperience (@ModelAttribute EmployeeExperience experience)
		{
				service.saveOrUpdate(experience);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Experience/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteExperience (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

}