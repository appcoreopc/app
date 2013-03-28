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

import com.appCore.personnel.User.Entity.Groups;

import com.appCore.personnel.User.Service.GroupsService;


@Controller
@RequestMapping("/User")
public class GroupsController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="groupsService")
		private GroupsService service;

		@RequestMapping(value = "/Groups/list", method = RequestMethod.GET)		
		public @ResponseBody List<Groups> listGroups () 
		{
				List<Groups> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Groups/get", method = RequestMethod.GET)		
		public @ResponseBody Groups getGroups (@RequestParam(value="id", required=true) Integer id ) 
		{
				Groups groups=service.get(id);
				return groups;
		}

		@RequestMapping(value = "/Groups/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddGroups (@RequestBody Groups groups)
		{
				service.add(groups);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Groups/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addGroups (@RequestBody Groups groups)
		{
				service.add(groups);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Groups/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateGroups (@RequestBody Groups groups)
		{
				service.saveOrUpdate(groups);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Groups/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteGroups (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}