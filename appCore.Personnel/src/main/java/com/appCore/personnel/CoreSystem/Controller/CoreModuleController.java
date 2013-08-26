package com.appCore.personnel.CoreSystem.Controller;

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
import com.appCore.personnel.CoreSystem.Entity.CoreModule;
import com.appCore.personnel.CoreSystem.Service.CoreModuleService;

@Controller
@RequestMapping("/CoreSystem")
public class CoreModuleController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="coreModuleService")
		private CoreModuleService service;

		@RequestMapping(value = "/CoreModule/list", method = RequestMethod.GET)		
		public @ResponseBody List<CoreModule> listCoreModule () 
		{
				List<CoreModule> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/CoreModule/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<CoreModule> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<CoreModule> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/CoreModule/get", method = RequestMethod.GET)		
		public @ResponseBody CoreModule getCoreModule (@RequestParam(value="id", required=true) Integer id ) 
		{
				CoreModule coreModule=service.get(id);
				return coreModule;
		}

		@RequestMapping(value = "/CoreModule/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddCoreModule (@RequestBody CoreModule coreModule)
		{
				service.add(coreModule);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/CoreModule/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addCoreModule (@RequestBody CoreModule coreModule)
		{
				service.add(coreModule);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/CoreModule/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateCoreModule (@RequestBody CoreModule coreModule)
		{
				service.saveOrUpdate(coreModule);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/CoreModule/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteCoreModule (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}