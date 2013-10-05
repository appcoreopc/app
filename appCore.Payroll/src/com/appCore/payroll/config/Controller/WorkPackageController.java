package com.appCore.payroll.config.Controller;

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
import com.appCore.payroll.config.Entity.WorkPackage;
import com.appCore.payroll.config.Service.WorkPackageService;

@Controller
@RequestMapping("/config")
public class WorkPackageController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="workPackageService")
		private WorkPackageService service;

		@RequestMapping(value = "/WorkPackage/list", method = RequestMethod.GET)		
		public @ResponseBody List<WorkPackage> listWorkPackage () 
		{
				List<WorkPackage> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/WorkPackage/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<WorkPackage> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<WorkPackage> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/WorkPackage/get", method = RequestMethod.GET)		
		public @ResponseBody WorkPackage getWorkPackage (@RequestParam(value="id", required=true) Integer id ) 
		{
				WorkPackage workPackage=service.get(id);
				return workPackage;
		}

		@RequestMapping(value = "/WorkPackage/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddWorkPackage (@RequestBody WorkPackage workPackage)
		{
				service.add(workPackage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/WorkPackage/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addWorkPackage (@RequestBody WorkPackage workPackage)
		{
				service.add(workPackage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/WorkPackage/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateWorkPackage (@RequestBody WorkPackage workPackage)
		{
				service.saveOrUpdate(workPackage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/WorkPackage/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteWorkPackage (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}