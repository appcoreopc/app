package com.appCore.personnel.Core.Calendar.Controller;

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
import com.appCore.personnel.Core.Calendar.Entity.Notification;
import com.appCore.personnel.Core.Calendar.Service.NotificationService;

@Controller
@RequestMapping("/Calendar")
public class NotificationController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="notificationService")
		private NotificationService service;

		@RequestMapping(value = "/Notification/list", method = RequestMethod.GET)		
		public @ResponseBody List<Notification> listNotification () 
		{
				List<Notification> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/Notification/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Notification> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<Notification> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/Notification/get", method = RequestMethod.GET)		
		public @ResponseBody Notification getNotification (@RequestParam(value="id", required=true) Integer id ) 
		{
				Notification notification=service.get(id);
				return notification;
		}

		@RequestMapping(value = "/Notification/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddNotification (@RequestBody Notification notification)
		{
				service.add(notification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Notification/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addNotification (@RequestBody Notification notification)
		{
				service.add(notification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Notification/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateNotification (@RequestBody Notification notification)
		{
				service.saveOrUpdate(notification);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Notification/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteNotification (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}