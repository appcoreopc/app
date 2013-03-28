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

import com.appCore.personnel.User.Entity.Role_UserGroup;

import com.appCore.personnel.User.Service.Role_UserGroupService;


@Controller
@RequestMapping("/User")
public class Role_UserGroupController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="role_UserGroupService")
		private Role_UserGroupService service;

		@RequestMapping(value = "/Role_UserGroup/list", method = RequestMethod.GET)		
		public @ResponseBody List<Role_UserGroup> listRole_UserGroup () 
		{
				List<Role_UserGroup> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Role_UserGroup/get", method = RequestMethod.GET)		
		public @ResponseBody Role_UserGroup getRole_UserGroup (@RequestParam(value="id", required=true) Integer id ) 
		{
				Role_UserGroup role_UserGroup=service.get(id);
				return role_UserGroup;
		}

		@RequestMapping(value = "/Role_UserGroup/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddRole_UserGroup (@RequestBody Role_UserGroup role_UserGroup)
		{
				service.add(role_UserGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Role_UserGroup/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addRole_UserGroup (@RequestBody Role_UserGroup role_UserGroup)
		{
				service.add(role_UserGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Role_UserGroup/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateRole_UserGroup (@RequestBody Role_UserGroup role_UserGroup)
		{
				service.saveOrUpdate(role_UserGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Role_UserGroup/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteRole_UserGroup (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}