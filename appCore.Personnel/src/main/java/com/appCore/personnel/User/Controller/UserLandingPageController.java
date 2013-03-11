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

import com.appCore.personnel.User.Entity.UserLandingPage;

import com.appCore.personnel.User.Service.UserLandingPageService;


@Controller
@RequestMapping("/User")
public class UserLandingPageController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="userLandingPageService")
		private UserLandingPageService service;

		@RequestMapping(value = "/UserLandingPage/list", method = RequestMethod.GET)		
		public @ResponseBody List<UserLandingPage> listUserLandingPage () 
		{
				List<UserLandingPage> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/UserLandingPage/get", method = RequestMethod.GET)		
		public @ResponseBody UserLandingPage getUserLandingPage (@RequestParam(value="id", required=true) Integer id ) 
		{
				UserLandingPage userLandingPage=service.get(id);
				return userLandingPage;
		}

		@RequestMapping(value = "/UserLandingPage/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddUserLandingPage (@RequestBody UserLandingPage userLandingPage)
		{
				service.add(userLandingPage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserLandingPage/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addUserLandingPage (@RequestBody UserLandingPage userLandingPage)
		{
				service.add(userLandingPage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserLandingPage/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateUserLandingPage (@RequestBody UserLandingPage userLandingPage)
		{
				service.saveOrUpdate(userLandingPage);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/UserLandingPage/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteUserLandingPage (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}