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

import com.appCore.personnel.User.Entity.UserGroup;

import com.appCore.personnel.User.Service.UserGroupService;


@Controller
@RequestMapping("/User")
public class UserGroupController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="userGroupService")
		private UserGroupService service;

		@RequestMapping(value = "/UserGroup/list", method = RequestMethod.GET)		
		public @ResponseBody List<UserGroup> listUserGroup () 
		{
				List<UserGroup> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/UserGroup/get", method = RequestMethod.GET)		
		public @ResponseBody UserGroup getUserGroup (@RequestParam(value="id", required=true) Integer id ) 
		{
				UserGroup userGroup=service.get(id);
				return userGroup;
		}

		@RequestMapping(value = "/UserGroup/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddUserGroup (@RequestBody UserGroup userGroup)
		{
				service.add(userGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserGroup/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addUserGroup (@RequestBody UserGroup userGroup)
		{
				service.add(userGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserGroup/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateUserGroup (@RequestBody UserGroup userGroup)
		{
				service.saveOrUpdate(userGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserGroup/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteUserGroup (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}