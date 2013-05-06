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
import com.appCore.personnel.Core.Calendar.Entity.OffDay;

import com.appCore.personnel.Core.Calendar.Service.OffDayService;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

@Controller
@RequestMapping("/Core/Calendar")
public class OffDayController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="offDayService")
		private OffDayService service;

		@RequestMapping(value = "/OffDay/list", method = RequestMethod.GET)		
		public @ResponseBody List<OffDay> listOffDay () 
		{
				List<OffDay> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/OffDay/get", method = RequestMethod.GET)		
		public @ResponseBody OffDay getOffDay (@RequestParam(value="id", required=true) Integer id) 
		{
				OffDay offDay=service.get(id);
				return offDay;
		}

		@RequestMapping(value = "/OffDay/add", method = RequestMethod.GET)
		public String renderAddOffDay (@ModelAttribute OffDay offDay)
		{
				service.add(offDay);
				return "View/Calendar/OffDay/add";
		}

		@RequestMapping(value = "/OffDay/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addOffDay (@RequestBody OffDay offDay)
		{
				service.add(offDay);
				return RequestStatusHelper.GenerateRequestStatusCreateOperation();
		}

		@RequestMapping(value = "/OffDay/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateOffDay (@RequestBody OffDay offDay)
		{
				service.saveOrUpdate(offDay);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/OffDay/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteOffDay (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/OffDay/edit", method = RequestMethod.GET)
		public String editOffDay ( Model model ) 
		{
				return "View/Calendar/OffDay/edit";
		}


}