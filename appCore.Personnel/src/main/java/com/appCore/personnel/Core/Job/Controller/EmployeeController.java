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
import com.appCore.personnel.Core.Entity.Section;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Job.Entity.Employee;

import com.appCore.personnel.Core.Job.Service.EmployeeService;


@Controller
@RequestMapping("/Job")
public class EmployeeController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeService")
		private EmployeeService service;

		@RequestMapping(value = "/Employee/list", method = RequestMethod.GET)		
		public @ResponseBody List<Employee> listEmployee () 
		{
				List<Employee> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/Employee/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Employee> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<Employee> list = service.getAllByCompany(id);
				return list;
		}	

		@RequestMapping(value = "/Employee/get", method = RequestMethod.GET)		
		public @ResponseBody Employee getEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				Employee employee=service.get(id);
				return employee;
		}

		@RequestMapping(value = "/Employee/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployee (@RequestBody Employee employee)
		{
				service.add(employee);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Employee/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployee (@RequestBody Employee employee)
		{
				service.add(employee);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Employee/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployee (@RequestBody Employee employee)
		{
				service.saveOrUpdate(employee);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Employee/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployee (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}