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
import com.appCore.personnel.Core.Calendar.Entity.HolidayLeaveEarningScheme;
import com.appCore.personnel.Core.Calendar.Service.HolidayLeaveEarningSchemeService;

@Controller
@RequestMapping("/Calendar")
public class HolidayLeaveEarningSchemeController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="holidayLeaveEarningSchemeService")
		private HolidayLeaveEarningSchemeService service;

		@RequestMapping(value = "/HolidayLeaveEarningScheme/list", method = RequestMethod.GET)		
		public @ResponseBody List<HolidayLeaveEarningScheme> listHolidayLeaveEarningScheme () 
		{
				List<HolidayLeaveEarningScheme> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/HolidayLeaveEarningScheme/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<HolidayLeaveEarningScheme> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<HolidayLeaveEarningScheme> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/HolidayLeaveEarningScheme/get", method = RequestMethod.GET)		
		public @ResponseBody HolidayLeaveEarningScheme getHolidayLeaveEarningScheme (@RequestParam(value="id", required=true) Integer id ) 
		{
				HolidayLeaveEarningScheme holidayLeaveEarningScheme=service.get(id);
				return holidayLeaveEarningScheme;
		}

		@RequestMapping(value = "/HolidayLeaveEarningScheme/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddHolidayLeaveEarningScheme (@RequestBody HolidayLeaveEarningScheme holidayLeaveEarningScheme)
		{
				service.add(holidayLeaveEarningScheme);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayLeaveEarningScheme/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addHolidayLeaveEarningScheme (@RequestBody HolidayLeaveEarningScheme holidayLeaveEarningScheme)
		{
				service.add(holidayLeaveEarningScheme);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayLeaveEarningScheme/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateHolidayLeaveEarningScheme (@RequestBody HolidayLeaveEarningScheme holidayLeaveEarningScheme)
		{
				service.saveOrUpdate(holidayLeaveEarningScheme);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayLeaveEarningScheme/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteHolidayLeaveEarningScheme (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}