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
import com.appCore.Requests.UserAuthenticationRequestStatus;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.User.Entity.Roles;
import com.appCore.personnel.User.Entity.Users;

import com.appCore.personnel.User.Service.UsersService;


@Controller
@RequestMapping("/Users")
public class UsersController
{ 

		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="usersService")
		private UsersService service;

		@RequestMapping(value = "/Users/list", method = RequestMethod.GET)		
		public @ResponseBody List<Users> listUsers () 
		{
				List<Users> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Users/get", method = RequestMethod.GET)		
		public @ResponseBody Users getUsers (@RequestParam(value="id", required=true) Integer id) 
		{
				Users users=service.get(id);
				return users;
		}
		
		@RequestMapping(value = "/Users/validateLogin", method = RequestMethod.GET)		
		public @ResponseBody UserAuthenticationRequestStatus getUsers (@ModelAttribute Users user) 
		{
				UserAuthenticationRequestStatus status = new UserAuthenticationRequestStatus(); 
				status.setMessageCode(-1);
				status.setMessageDescription("Login fails.");
				
				List<Users> getUserResult = service.get(user.getUsername(), user.getPassword());
				
				service.getRole(1);
				
				if (getUserResult.size() > 0)
				{
					status.setUsername(user.getUsername());
					// status.setEmployeeRole();
					status.setMessageCode(0);
					status.setMessageDescription("User logins successfully.");
				}
				
				return status; 
		}
		

		@RequestMapping(value = "/Users/add", method = RequestMethod.GET)
		public String renderAddUsers () 
		{
				return "View/User/Users/add";
		}

		@RequestMapping(value = "/Users/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addUsers (@RequestBody Users users)
		{
				boolean userAddState = service.add(users);
				if (userAddState)
					return RequestStatusHelper.GenerateRequestStatusSaveOperation();
				else 
					return RequestStatusHelper.GenerateErrorMessage("Unable to save duplicate user", -1);
		}

		@RequestMapping(value = "/Users/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateUsers (@RequestBody Users users)
		{
				service.saveOrUpdate(users);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Users/delete", method = RequestMethod.GET)
		public @ResponseBody String deleteUsers (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return "View/User/Users/delete";
		}

		@RequestMapping(value = "/Users/edit", method = RequestMethod.GET)
		public String editUsers () 
		{
			return "View/User/Users/edit";
		}

}