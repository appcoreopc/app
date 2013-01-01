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

import com.appCore.personnel.Core.Job.Entity.EmployeeGroup;
import com.appCore.personnel.Core.Job.Entity.JobType;

import com.appCore.personnel.Core.Job.Service.EmployeeGroupService;


@Controller
@RequestMapping("/Job")
public class EmployeeGroupController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeGroupService")
		private EmployeeGroupService service;

		@RequestMapping(value = "/EmployeeGroup/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeGroup> listEmployeeGroup () 
		{
				List<EmployeeGroup> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/EmployeeGroup/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeGroup> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeGroup> list = service.getAllByCompany(id);
				return list;
		}
				
		@RequestMapping(value = "/EmployeeGroup/configuredEmployeeGroup", method = RequestMethod.GET)		
		public @ResponseBody RequestStatus saveconfiguredHolidayGroup (@RequestParam(value="employeeId", required=true) int employeeId, int groupId, boolean isGrantAccess) 
		{
				service.saveconfiguredEmployeeGroup(employeeId, groupId, isGrantAccess);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		
		@RequestMapping(value = "/EmployeeGroup/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeGroup getEmployeeGroup (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeGroup employeeGroup=service.get(id);
				return employeeGroup;
		}

		@RequestMapping(value = "/EmployeeGroup/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeGroup (@RequestBody EmployeeGroup employeeGroup)
		{
				service.add(employeeGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeGroup/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeGroup (@RequestBody EmployeeGroup employeeGroup)
		{
				service.add(employeeGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeGroup/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeGroup (@RequestBody EmployeeGroup employeeGroup)
		{
				service.saveOrUpdate(employeeGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeGroup/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeGroup (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}