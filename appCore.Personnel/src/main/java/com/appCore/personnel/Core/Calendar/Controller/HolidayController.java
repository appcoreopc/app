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
import com.appCore.personnel.Core.Calendar.Entity.Holiday;

import com.appCore.personnel.Core.Calendar.Service.HolidayService;
import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

@Controller
@RequestMapping("/Core/Calendar")
public class HolidayController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="holidayService")
		private HolidayService service;

		@RequestMapping(value = "/Holiday/list", method = RequestMethod.GET)		
		public @ResponseBody List<Holiday> listHoliday () 
		{
				List<Holiday> list = service.getAll();
				return list;
				
		}

		@RequestMapping(value = "/Holiday/listByCompany", method = RequestMethod.GET)
		public @ResponseBody
		List<Holiday> listByCompany(@RequestParam(value = "id", required = true) Integer id) 
		{
			List<Holiday> list = service.getAllByCompany(id);
			return list;
		}
		
		@RequestMapping(value = "/Holiday/get", method = RequestMethod.GET)		
		public @ResponseBody Holiday getHoliday (@RequestParam(value="id", required=true) Integer id) 
		{
				Holiday holiday=service.get(id);
				return holiday;
		}

		@RequestMapping(value = "/Holiday/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddHoliday (@RequestBody Holiday holiday)
		{
				service.add(holiday);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Holiday/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addHoliday (@RequestBody Holiday holiday)
		{
				service.add(holiday);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Holiday/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateHoliday (@RequestBody Holiday holiday)
		{
				service.saveOrUpdate(holiday);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		@RequestMapping(value = "/Holiday/saveOrUpdate", method = RequestMethod.GET)
		public @ResponseBody RequestStatus saveOrUpdateHolidayGetRequest (Holiday holiday)
		{
				service.saveOrUpdate(holiday);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Holiday/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteHoliday (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/Holiday/edit", method = RequestMethod.GET)
		public String editHoliday ( Model model ) 
		{
				return "View/Calendar/Holiday/edit";
		}


}