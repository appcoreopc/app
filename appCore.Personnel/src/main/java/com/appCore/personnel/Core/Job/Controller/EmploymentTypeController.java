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
import com.appCore.personnel.Core.Job.Entity.EmployeeExpertise;
import com.appCore.personnel.Core.Job.Entity.EmploymentType;
import com.appCore.personnel.Core.Job.Entity.Grade;

import com.appCore.personnel.Core.Job.Service.EmploymentTypeService;


@Controller
@RequestMapping("/Core/Job")
public class EmploymentTypeController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employmentTypeService")
		private EmploymentTypeService service;

		@RequestMapping(value = "/EmploymentType/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmploymentType> listEmploymentType () 
		{
				List<EmploymentType> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmploymentType/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<EmploymentType> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				
				List<EmploymentType> list = service.getAllByCompany(id);
				return list;
		}
		
		@RequestMapping(value = "/EmploymentType/get", method = RequestMethod.GET)		
		public @ResponseBody EmploymentType getEmploymentType (@RequestParam(value="id", required=true) Integer id) 
		{
				EmploymentType employmentType=service.get(id);
				return employmentType;
		}
		
		
		@RequestMapping(value = "/EmploymentType/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmploymentType (@RequestBody EmploymentType employmentType)
		{
				service.add(employmentType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmploymentType/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmploymentType (@RequestBody EmploymentType employmentType)
		{
				service.add(employmentType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmploymentType/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmploymentType (@RequestBody EmploymentType employmentType)
		{
				service.saveOrUpdate(employmentType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmploymentType/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmploymentType (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/EmploymentType/edit", method = RequestMethod.GET)
		public String editEmploymentType ( Model model ) 
		{
				return "View/Job/EmploymentType/edit";
		}


}