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
import com.appCore.personnel.Core.Job.Entity.EmploymentTypeInfo;

import com.appCore.personnel.Core.Job.Service.EmploymentTypeInfoService;


@Controller
@RequestMapping("/Core/Job")
public class EmploymentTypeInfoController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employmentTypeInfoService")
		private EmploymentTypeInfoService service;

		@RequestMapping(value = "/EmploymentTypeInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmploymentTypeInfo> listEmploymentTypeInfo () 
		{
				List<EmploymentTypeInfo> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/EmploymentTypeInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<EmploymentTypeInfo> listEmploymentTypeInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<EmploymentTypeInfo> list = service.getAllByRefEntity(id);
				return list;
		}

		@RequestMapping(value = "/EmploymentTypeInfo/get", method = RequestMethod.GET)		
		public @ResponseBody EmploymentTypeInfo getEmploymentTypeInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				EmploymentTypeInfo employmentTypeInfo=service.get(id);
				return employmentTypeInfo;
		}
	

		@RequestMapping(value = "/EmploymentTypeInfo/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmploymentTypeInfo (@RequestBody EmploymentTypeInfo employmentTypeInfo)
		{
				service.add(employmentTypeInfo);
				return RequestStatusHelper.GenerateRequestStatusCreateOperation();
		}

		@RequestMapping(value = "/EmploymentTypeInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmploymentTypeInfo (@RequestBody EmploymentTypeInfo employmentTypeInfo)
		{
				int saveId = service.saveOrUpdate(employmentTypeInfo);
				RequestStatus status = RequestStatusHelper.GenerateRequestStatusSaveOperation();
				status.setSaveCode(saveId);
				return status;
		}

		@RequestMapping(value = "/EmploymentTypeInfo/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmploymentTypeInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}