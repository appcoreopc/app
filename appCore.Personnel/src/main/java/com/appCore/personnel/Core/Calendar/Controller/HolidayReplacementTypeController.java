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
import com.appCore.personnel.Core.Calendar.Entity.HolidayReplacementType;
import com.appCore.personnel.Core.Calendar.Service.HolidayReplacementTypeService;

@Controller
@RequestMapping("/Calendar")
public class HolidayReplacementTypeController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="holidayReplacementTypeService")
		private HolidayReplacementTypeService service;

		@RequestMapping(value = "/HolidayReplacementType/list", method = RequestMethod.GET)		
		public @ResponseBody List<HolidayReplacementType> listHolidayReplacementType () 
		{
				List<HolidayReplacementType> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/HolidayReplacementType/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<HolidayReplacementType> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<HolidayReplacementType> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/HolidayReplacementType/get", method = RequestMethod.GET)		
		public @ResponseBody HolidayReplacementType getHolidayReplacementType (@RequestParam(value="id", required=true) Integer id ) 
		{
				HolidayReplacementType holidayReplacementType=service.get(id);
				return holidayReplacementType;
		}

		@RequestMapping(value = "/HolidayReplacementType/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddHolidayReplacementType (@RequestBody HolidayReplacementType holidayReplacementType)
		{
				service.add(holidayReplacementType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayReplacementType/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addHolidayReplacementType (@RequestBody HolidayReplacementType holidayReplacementType)
		{
				service.add(holidayReplacementType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayReplacementType/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateHolidayReplacementType (@RequestBody HolidayReplacementType holidayReplacementType)
		{
				service.saveOrUpdate(holidayReplacementType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/HolidayReplacementType/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteHolidayReplacementType (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}