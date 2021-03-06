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

import com.appCore.personnel.Core.Job.Entity.EmployeeMembership;
import com.appCore.personnel.Core.Job.Entity.EmployeeResidence;

import com.appCore.personnel.Core.Job.Service.EmployeeMembershipService;


@Controller
@RequestMapping("/Job")
public class EmployeeMembershipController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeMembershipService")
		private EmployeeMembershipService service;

		@RequestMapping(value = "/EmployeeMembership/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeMembership> listEmployeeMembership () 
		{
				List<EmployeeMembership> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmployeeMembership/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeMembership getEmployeeMembership (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeMembership employeeMembership=service.get(id);
				return employeeMembership;
		}
		
		@RequestMapping(value = "/EmployeeMembership/getByEmployee", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeMembership> getByEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeMembership> employeeResidence=service.getByEmployee(id);
				return employeeResidence;
		}


		@RequestMapping(value = "/EmployeeMembership/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeMembership (@RequestBody EmployeeMembership employeeMembership)
		{
				service.add(employeeMembership);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeMembership/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeMembership (@RequestBody EmployeeMembership employeeMembership)
		{
				service.add(employeeMembership);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeMembership/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeMembership (@RequestBody EmployeeMembership employeeMembership)
		{
				service.saveOrUpdate(employeeMembership);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeMembership/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeMembership (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}