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
import com.appCore.personnel.Core.Calendar.Entity.HolidayGroup;

import com.appCore.personnel.Core.Calendar.Service.HolidayGroupService;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;


@Controller
@RequestMapping("/Core/Calendar")
public class HolidayGroupController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="holidayGroupService")
		private HolidayGroupService service;

		@RequestMapping(value = "/HolidayGroup/list", method = RequestMethod.GET)		
		public @ResponseBody List<HolidayGroup> listHolidayGroup () 
		{
				List<HolidayGroup> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/HolidayGroup/get", method = RequestMethod.GET)		
		public @ResponseBody HolidayGroup getHolidayGroup (@RequestParam(value="id", required=true) Integer id) 
		{
				HolidayGroup holidayGroup=service.get(id);
				return holidayGroup;
		}
		
		@RequestMapping(value = "/HolidayGroup/getTest", method = RequestMethod.GET)		
		public @ResponseBody RequestStatus getHolidayGroup (@RequestParam(value="id", required=true) Integer id, @RequestParam(value="nid", required=true) Integer nid) 
		{
				service.getAllTest(id, nid);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		@RequestMapping(value = "/HolidayGroup/configuredHolidayGroup", method = RequestMethod.GET)		
		public @ResponseBody RequestStatus saveconfiguredHolidayGroup (@RequestParam(value="id", required=true) int id, int holidayId, boolean isGrantAccess) 
		{
				service.saveconfiguredHolidayGroup(id, holidayId, isGrantAccess);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		@RequestMapping(value = "/HolidayGroup/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddHolidayGroup (HolidayGroup holidayGroup)
		{
				service.add(holidayGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayGroup/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addHolidayGroup (@RequestBody HolidayGroup holidayGroup)
		{
				service.add(holidayGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayGroup/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateHolidayGroup (@RequestBody HolidayGroup holidayGroup)
		{
				service.saveOrUpdate(holidayGroup);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		@RequestMapping(value = "/HolidayGroup/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteHolidayGroup (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/HolidayGroup/edit", method = RequestMethod.GET)
		public String editHolidayGroup ( Model model ) 
		{
				return "View/Calendar/HolidayGroup/edit";
		}


}