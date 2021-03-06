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
import com.appCore.personnel.Core.Job.Entity.EmployeeMembership;

import com.appCore.personnel.Core.Job.Service.EmployeeExpertiseService;


@Controller
@RequestMapping("/Job")
public class EmployeeExpertiseController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeExpertiseService")
		private EmployeeExpertiseService service;

		@RequestMapping(value = "/EmployeeExpertise/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeExpertise> listEmployeeExpertise () 
		{
				List<EmployeeExpertise> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmployeeExpertise/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeExpertise getEmployeeExpertise (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeExpertise employeeExpertise=service.get(id);
				return employeeExpertise;
		}
		
		@RequestMapping(value = "/EmployeeExpertise/getByEmployee", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeExpertise> getByEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeExpertise> employeeResidence=service.getByEmployee(id);
				return employeeResidence;
		}


		@RequestMapping(value = "/EmployeeExpertise/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeExpertise (@RequestBody EmployeeExpertise employeeExpertise)
		{
				service.add(employeeExpertise);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeExpertise/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeExpertise (@RequestBody EmployeeExpertise employeeExpertise)
		{
				service.add(employeeExpertise);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeExpertise/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeExpertise (@RequestBody EmployeeExpertise employeeExpertise)
		{
				service.saveOrUpdate(employeeExpertise);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeExpertise/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeExpertise (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}