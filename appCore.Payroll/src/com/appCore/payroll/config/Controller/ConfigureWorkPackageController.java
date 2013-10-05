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
import com.appCore.payroll.config.Entity.ConfigureWorkPackage;
import com.appCore.payroll.config.Service.ConfigureWorkPackageService;

@Controller
@RequestMapping("/config")
public class ConfigureWorkPackageController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="configureWorkPackageService")
		private ConfigureWorkPackageService service;

		@RequestMapping(value = "/ConfigureWorkPackage/list", method = RequestMethod.GET)		
		public @ResponseBody List<ConfigureWorkPackage> listConfigureWorkPackage () 
		{
				List<ConfigureWorkPackage> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/ConfigureWorkPackage/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<ConfigureWorkPackage> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<ConfigureWorkPackage> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/ConfigureWorkPackage/get", method = RequestMethod.GET)		
		public @ResponseBody ConfigureWorkPackage getConfigureWorkPackage (@RequestParam(value="id", required=true) Integer id ) 
		{
				ConfigureWorkPackage configureWorkPackage=service.get(id);
				return configureWorkPackage;
		}

		@RequestMapping(value = "/ConfigureWorkPackage/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddConfigureWorkPackage (@RequestBody ConfigureWorkPackage configureWorkPackage)
		{
				service.add(configureWorkPackage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ConfigureWorkPackage/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addConfigureWorkPackage (@RequestBody ConfigureWorkPackage configureWorkPackage)
		{
				service.add(configureWorkPackage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ConfigureWorkPackage/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateConfigureWorkPackage (@RequestBody ConfigureWorkPackage configureWorkPackage)
		{
				service.saveOrUpdate(configureWorkPackage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ConfigureWorkPackage/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteConfigureWorkPackage (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}