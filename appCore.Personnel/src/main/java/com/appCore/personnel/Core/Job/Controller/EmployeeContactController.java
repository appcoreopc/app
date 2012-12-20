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

import com.appCore.personnel.Core.Job.Service.EmployeeContactService;


@Controller
@RequestMapping("/Job")
public class EmployeeContactController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeContactService")
		private EmployeeContactService service;

		@RequestMapping(value = "/EmployeeContact/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeContact> listEmployeeContact () 
		{
				List<EmployeeContact> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmployeeContact/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeContact getEmployeeContact (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeContact employeeContact=service.get(id);
				return employeeContact;
		}
		
		@RequestMapping(value = "/EmployeeContact/getByEmployee", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeContact> getContactByEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeContact> employeeContact=service.getByEmployee(id);
				return employeeContact;
		}
		

		@RequestMapping(value = "/EmployeeContact/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeContact (@RequestBody EmployeeContact employeeContact)
		{
				service.add(employeeContact);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeContact/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeContact (@RequestBody EmployeeContact employeeContact)
		{
				service.add(employeeContact);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeContact/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeContact (@RequestBody EmployeeContact employeeContact)
		{
				service.saveOrUpdate(employeeContact);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeContact/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeContact (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}