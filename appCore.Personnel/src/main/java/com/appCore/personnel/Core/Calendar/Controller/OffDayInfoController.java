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
import com.appCore.personnel.Core.Calendar.Entity.OffDayInfo;

import com.appCore.personnel.Core.Calendar.Service.OffDayInfoService;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;


@Controller
@RequestMapping("/Core/Calendar")
public class OffDayInfoController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="offDayInfoService")
		private OffDayInfoService service;

		@RequestMapping(value = "/OffDayInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<OffDayInfo> listOffDayInfo () 
		{
				List<OffDayInfo> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/OffDayInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<OffDayInfo> listOffDayInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<OffDayInfo> list = service.getAllByRefEntity(id);
				return list;
		}
		
		@RequestMapping(value = "/OffDayInfo/get", method = RequestMethod.GET)		
		public @ResponseBody OffDayInfo getOffDayInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				OffDayInfo offDayInfo=service.get(id);
				return offDayInfo;
		}

		@RequestMapping(value = "/OffDayInfo/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddOffDayInfo (@ModelAttribute OffDayInfo offDayInfo)
		{
				service.add(offDayInfo);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/OffDayInfo/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addOffDayInfo (@RequestBody OffDayInfo offDayInfo)
		{
				service.add(offDayInfo);
				return RequestStatusHelper.GenerateRequestStatusCreateOperation();
		}

		@RequestMapping(value = "/OffDayInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateOffDayInfo (@RequestBody OffDayInfo offDayInfo)
		{
				service.saveOrUpdate(offDayInfo);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/OffDayInfo/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteOffDayInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/OffDayInfo/edit", method = RequestMethod.GET)
		public String editOffDayInfo ( Model model ) 
		{
				return "View/Calendar/OffDayInfo/edit";
		}


}