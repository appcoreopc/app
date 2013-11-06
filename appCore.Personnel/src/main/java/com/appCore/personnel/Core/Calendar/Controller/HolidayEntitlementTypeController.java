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
import com.appCore.personnel.Core.Calendar.Entity.HolidayEntitlementType;
import com.appCore.personnel.Core.Calendar.Service.HolidayEntitlementTypeService;

@Controller
@RequestMapping("/Calendar")
public class HolidayEntitlementTypeController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="holidayEntitlementTypeService")
		private HolidayEntitlementTypeService service;

		@RequestMapping(value = "/HolidayEntitlementType/list", method = RequestMethod.GET)		
		public @ResponseBody List<HolidayEntitlementType> listHolidayEntitlementType () 
		{
				List<HolidayEntitlementType> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/HolidayEntitlementType/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<HolidayEntitlementType> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<HolidayEntitlementType> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/HolidayEntitlementType/get", method = RequestMethod.GET)		
		public @ResponseBody HolidayEntitlementType getHolidayEntitlementType (@RequestParam(value="id", required=true) Integer id ) 
		{
				HolidayEntitlementType holidayEntitlementType=service.get(id);
				return holidayEntitlementType;
		}

		@RequestMapping(value = "/HolidayEntitlementType/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddHolidayEntitlementType (@RequestBody HolidayEntitlementType holidayEntitlementType)
		{
				service.add(holidayEntitlementType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayEntitlementType/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addHolidayEntitlementType (@RequestBody HolidayEntitlementType holidayEntitlementType)
		{
				service.add(holidayEntitlementType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayEntitlementType/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateHolidayEntitlementType (@RequestBody HolidayEntitlementType holidayEntitlementType)
		{
				service.saveOrUpdate(holidayEntitlementType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayEntitlementType/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteHolidayEntitlementType (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}