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

import com.appCore.personnel.User.Entity.UserProfileConfiguration;

import com.appCore.personnel.User.Service.UserProfileConfigurationService;

@Controller
@RequestMapping("/User")
public class UserProfileConfigurationController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="userProfileConfigurationService")
		private UserProfileConfigurationService service;

		@RequestMapping(value = "/UserProfileConfiguration/list", method = RequestMethod.GET)		
		public @ResponseBody List<UserProfileConfiguration> listUserProfileConfiguration () 
		{
				List<UserProfileConfiguration> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/UserProfileConfiguration/get", method = RequestMethod.GET)		
		public @ResponseBody UserProfileConfiguration getUserProfileConfiguration (@RequestParam(value="id", required=true) Integer id ) 
		{
				UserProfileConfiguration userProfileConfiguration=service.get(id);
				return userProfileConfiguration;
		}

		@RequestMapping(value = "/UserProfileConfiguration/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddUserProfileConfiguration (@RequestBody UserProfileConfiguration userProfileConfiguration)
		{
				service.add(userProfileConfiguration);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserProfileConfiguration/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addUserProfileConfiguration (@RequestBody UserProfileConfiguration userProfileConfiguration)
		{
				service.add(userProfileConfiguration);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserProfileConfiguration/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateUserProfileConfiguration (@RequestBody UserProfileConfiguration userProfileConfiguration)
		{
				service.saveOrUpdate(userProfileConfiguration);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserProfileConfiguration/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteUserProfileConfiguration (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}