package com.appCore.personnel.Core.Controller;

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
import com.appCore.personnel.Core.Entity.DivisionInfo;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.DivisionInfoService;

@Controller
@RequestMapping("/Core")
public class DivisionInfoController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="divisionInfoService")
		private DivisionInfoService service;

		@RequestMapping(value = "/DivisionInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<DivisionInfo> listDivisionInfo () 
		{
				List<DivisionInfo> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/DivisionInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<DivisionInfo> listDivisionInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<DivisionInfo> list = service.getAllByRefEntity(id);
				return list;
		}
	
		@RequestMapping(value = "/DivisionInfo/get", method = RequestMethod.GET)		
		public @ResponseBody DivisionInfo getDivisionInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				DivisionInfo divisionInfo=service.get(id);
				return divisionInfo;
		}
		
		@RequestMapping(value = "/DivisionInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addDivisionInfo (@RequestBody DivisionInfo divisionInfo)
		{
				service.add(divisionInfo);
				return "View/Core/DivisionInfo/add";
		}

		@RequestMapping(value = "/DivisionInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateDivisionInfo (@RequestBody DivisionInfo divisionInfo)
		{
				int saveId = service.saveOrUpdate(divisionInfo);
				RequestStatus status = RequestStatusHelper.GenerateRequestStatusSaveOperation();
				status.setSaveCode(saveId);
				return status;
		}

		@RequestMapping(value = "/DivisionInfo/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteDivisionInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
		
}