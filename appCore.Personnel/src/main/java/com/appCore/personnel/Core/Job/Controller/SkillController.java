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
import com.appCore.personnel.Core.Job.Entity.EmployeeSkill;

import com.appCore.personnel.Core.Job.Service.SkillService;


@Controller
@RequestMapping("/Job")
public class SkillController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		
		@Resource(name="skillService")
		private SkillService service;

		@RequestMapping(value = "/Skill/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeSkill> listSkill () 
		{
				List<EmployeeSkill> list = service.getAll();
				return list;
		}
				
		@RequestMapping(value = "/Skill/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeSkill getSkill (@RequestParam(value="id", required=true) Integer id) 
		{
				EmployeeSkill skill=service.get(id);
				return skill;
		}

		@RequestMapping(value = "/Skill/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus renderAddSkill (@RequestBody EmployeeSkill skill)
		{
			service.add(skill);
			return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		@RequestMapping(value = "/Skill/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateSkill (@RequestBody EmployeeSkill skill)
		{
				service.saveOrUpdate(skill);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Skill/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteSkill (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		
}