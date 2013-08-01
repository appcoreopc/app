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
import com.appCore.personnel.User.Entity.UserLanding;

import com.appCore.personnel.User.Service.UserLandingService;


@Controller
@RequestMapping("/User")
public class UserLandingController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="userLandingService")
		private UserLandingService service;

		@RequestMapping(value = "/UserLanding/list", method = RequestMethod.GET)		
		public @ResponseBody List<UserLanding> listUserLanding () 
		{
				List<UserLanding> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/UserLanding/get", method = RequestMethod.GET)		
		public @ResponseBody List<ScriptWidget> getUserLanding (@RequestParam(value="userId", required=true) Integer userId, @RequestParam(required=true) Integer applicationType) 
		{
				return service.get(userId, applicationType);
		}
		
		@RequestMapping(value = "/UserLanding/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddUserLanding (@RequestBody UserLanding userLanding)
		{
				service.add(userLanding);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserLanding/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addUserLanding (@RequestBody UserLanding userLanding)
		{
				service.add(userLanding);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserLanding/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateUserLanding (@RequestBody UserLanding userLanding)
		{
				service.saveOrUpdate(userLanding);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserLanding/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteUserLanding (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

}