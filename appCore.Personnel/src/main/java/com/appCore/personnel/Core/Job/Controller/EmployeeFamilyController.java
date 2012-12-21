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

import com.appCore.personnel.Core.Job.Entity.EmployeeFamily;
import com.appCore.personnel.Core.Job.Entity.EmployeeResidence;

import com.appCore.personnel.Core.Job.Service.EmployeeFamilyService;


@Controller
@RequestMapping("/Job")
public class EmployeeFamilyController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeFamilyService")
		private EmployeeFamilyService service;

		@RequestMapping(value = "/EmployeeFamily/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeFamily> listEmployeeFamily () 
		{
				List<EmployeeFamily> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmployeeFamily/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeFamily getEmployeeFamily (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeFamily employeeFamily=service.get(id);
				return employeeFamily;
		}
		
		@RequestMapping(value = "/EmployeeFamily/getByEmployee", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeFamily> getByEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeFamily> employeeFamily=service.getByEmployee(id);
				return employeeFamily;
		}

		@RequestMapping(value = "/EmployeeFamily/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeFamily (@RequestBody EmployeeFamily employeeFamily)
		{
				service.add(employeeFamily);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeFamily/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeFamily (@RequestBody EmployeeFamily employeeFamily)
		{
				service.add(employeeFamily);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeFamily/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeFamily (@RequestBody EmployeeFamily employeeFamily)
		{
				service.saveOrUpdate(employeeFamily);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeFamily/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeFamily (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}