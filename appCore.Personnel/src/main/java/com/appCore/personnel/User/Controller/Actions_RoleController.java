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

import com.appCore.personnel.User.Entity.Forms_Actions_Role;

import com.appCore.personnel.User.Service.Actions_RoleService;


@Controller
@RequestMapping("/User")
public class Actions_RoleController 
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="actions_RoleService")
		private Actions_RoleService service;

		@RequestMapping(value = "/Actions_Role/list", method = RequestMethod.GET)		
		public @ResponseBody List<Forms_Actions_Role> listActions_Role () 
		{
				List<Forms_Actions_Role> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Actions_Role/get", method = RequestMethod.GET)		
		public @ResponseBody Forms_Actions_Role getActions_Role (@RequestParam(value="id", required=true) Integer id ) 
		{
				Forms_Actions_Role actions_Role=service.get(id);
				return actions_Role;
		}

		@RequestMapping(value = "/Actions_Role/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddActions_Role (@RequestBody Forms_Actions_Role actions_Role)
		{
				service.add(actions_Role);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Actions_Role/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addActions_Role (@RequestBody Forms_Actions_Role actions_Role)
		{
				service.add(actions_Role);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Actions_Role/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateActions_Role (@RequestBody Forms_Actions_Role actions_Role)
		{
				service.saveOrUpdate(actions_Role);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Actions_Role/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteActions_Role (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}