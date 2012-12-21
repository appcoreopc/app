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

import com.appCore.personnel.Core.Job.Entity.EmployeeEmployment;
import com.appCore.personnel.Core.Job.Entity.EmployeeResidence;

import com.appCore.personnel.Core.Job.Service.EmployeeResidenceService;


@Controller
@RequestMapping("/Job")
public class EmployeeResidenceController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeResidenceService")
		private EmployeeResidenceService service;

		@RequestMapping(value = "/EmployeeResidence/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeResidence> listEmployeeResidence () 
		{
				List<EmployeeResidence> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmployeeResidence/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeResidence getEmployeeResidence (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeResidence employeeResidence=service.get(id);
				return employeeResidence;
		}
		
		@RequestMapping(value = "/EmployeeResidence/getByEmployee", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeResidence> getByEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeResidence> employeeResidence=service.getByEmployee(id);
				return employeeResidence;
		}


		@RequestMapping(value = "/EmployeeResidence/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeResidence (@RequestBody EmployeeResidence employeeResidence)
		{
				service.add(employeeResidence);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeResidence/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeResidence (@RequestBody EmployeeResidence employeeResidence)
		{
				service.add(employeeResidence);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeResidence/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeResidence (@RequestBody EmployeeResidence employeeResidence)
		{
				service.saveOrUpdate(employeeResidence);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeResidence/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeResidence (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}