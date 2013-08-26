package com.appCore.personnel.User.Controller;

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
import com.appCore.personnel.User.Entity.ScriptWidget;
import com.appCore.personnel.User.Service.ScriptWidgetService;

@Controller
@RequestMapping("/User")
public class ScriptWidgetController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="scriptWidgetService")
		private ScriptWidgetService service;

		@RequestMapping(value = "/ScriptWidget/list", method = RequestMethod.GET)		
		public @ResponseBody List<ScriptWidget> listScriptWidget () 
		{
				List<ScriptWidget> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/ScriptWidget/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<ScriptWidget> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<ScriptWidget> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/ScriptWidget/get", method = RequestMethod.GET)		
		public @ResponseBody ScriptWidget getScriptWidget (@RequestParam(value="id", required=true) Integer id ) 
		{
				ScriptWidget scriptWidget=service.get(id);
				return scriptWidget;
		}

		@RequestMapping(value = "/ScriptWidget/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddScriptWidget (@RequestBody ScriptWidget scriptWidget)
		{
				service.add(scriptWidget);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ScriptWidget/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addScriptWidget (@RequestBody ScriptWidget scriptWidget)
		{
				service.add(scriptWidget);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ScriptWidget/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateScriptWidget (@RequestBody ScriptWidget scriptWidget)
		{
				service.saveOrUpdate(scriptWidget);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/ScriptWidget/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteScriptWidget (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}