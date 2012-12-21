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

import com.appCore.personnel.User.Entity.Actions;

import com.appCore.personnel.User.Service.ActionsService;


@Controller
@RequestMapping("/User")
public class ActionsController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="actionsService")
		private ActionsService service;

		@RequestMapping(value = "/Actions/list", method = RequestMethod.GET)		
		public @ResponseBody List<Actions> listActions () 
		{
				List<Actions> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Actions/get", method = RequestMethod.GET)		
		public @ResponseBody Actions getActions (@RequestParam(value="id", required=true) Integer id ) 
		{
				Actions actions=service.get(id);
				return actions;
		}

		@RequestMapping(value = "/Actions/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddActions (@RequestBody Actions actions)
		{
				service.add(actions);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Actions/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addActions (@RequestBody Actions actions)
		{
				service.add(actions);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Actions/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateActions (@RequestBody Actions actions)
		{
				service.saveOrUpdate(actions);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Actions/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteActions (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}