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

import com.appCore.personnel.Core.Job.Entity.EmployeeContact;
import com.appCore.personnel.Core.Job.Entity.EmployeeEmployment;

import com.appCore.personnel.Core.Job.Service.EmployeeEmploymentService;


@Controller
@RequestMapping("/Job")
public class EmployeeEmploymentController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeEmploymentService")
		private EmployeeEmploymentService service;

		@RequestMapping(value = "/EmployeeEmployment/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeEmployment> listEmployeeEmployment () 
		{
				List<EmployeeEmployment> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmployeeEmployment/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeEmployment getEmployeeEmployment (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeEmployment employeeEmployment=service.get(id);
				return employeeEmployment;
		}
		
		@RequestMapping(value = "/EmployeeEmployment/getByEmployee", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeEmployment> getByEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeEmployment> employeeEmployment=service.getByEmployee(id);
				return employeeEmployment;
		}

		@RequestMapping(value = "/EmployeeEmployment/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeEmployment (@RequestBody EmployeeEmployment employeeEmployment)
		{
				service.add(employeeEmployment);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeEmployment/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeEmployment (@RequestBody EmployeeEmployment employeeEmployment)
		{
				service.add(employeeEmployment);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeEmployment/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeEmployment (@RequestBody EmployeeEmployment employeeEmployment)
		{
				service.saveOrUpdate(employeeEmployment);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeEmployment/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeEmployment (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}