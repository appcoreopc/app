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
import com.appCore.personnel.Core.Job.Entity.EmployeeQualification;

import com.appCore.personnel.Core.Job.Service.EmployeeQualificationService;


@Controller
@RequestMapping("/Job")
public class EmployeeQualificationController
{ 

		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeQualificationService")
		private EmployeeQualificationService service;

		@RequestMapping(value = "/EmployeeQualification/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeQualification> listQualification () 
		{
				List<EmployeeQualification> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/EmployeeQualification/getByEmployee", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeQualification> getContactByEmployee (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeQualification> employeeContact=service.getByEmployee(id);
				return employeeContact;
		}
		
			
		@RequestMapping(value = "/EmployeeQualification/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeQualification getQualification (@RequestParam(value="id", required=true) Integer id) 
		{
				EmployeeQualification qualification=service.get(id);
				return qualification;
		}

		
		@RequestMapping(value = "/EmployeeQualification/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addQualification (@RequestBody EmployeeQualification qualification)
		{
				service.add(qualification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeQualification/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateQualification (@RequestBody EmployeeQualification qualification)
		{
				service.saveOrUpdate(qualification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeQualification/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteQualification (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
		
}