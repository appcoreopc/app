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
import com.appCore.personnel.Core.Entity.UnitInfo;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.UnitInfoService;


@Controller
@RequestMapping("/Core")
public class UnitInfoController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="unitInfoService")
		private UnitInfoService service;

		@RequestMapping(value = "/UnitInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<UnitInfo> listUnitInfo () 
		{
				List<UnitInfo> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/UnitInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<UnitInfo> listUnitInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<UnitInfo> list = service.getAllByRefEntity(id);
				return list;
		}

		@RequestMapping(value = "/UnitInfo/get", method = RequestMethod.GET)		
		public @ResponseBody UnitInfo getUnitInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				UnitInfo unitInfo=service.get(id);
				return unitInfo;
		}
		
		
		@RequestMapping(value = "/UnitInfo/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addUnitInfo (@RequestBody UnitInfo unitInfo)
		{
				service.add(unitInfo);
				return RequestStatusHelper.GenerateRequestStatusCreateOperation();
		}

		@RequestMapping(value = "/UnitInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateUnitInfo (@RequestBody UnitInfo unitInfo)
		{
				int saveId = service.saveOrUpdate(unitInfo);
				RequestStatus status = RequestStatusHelper.GenerateRequestStatusSaveOperation();
				status.setSaveCode(saveId);
				return status;
		}

		@RequestMapping(value = "/UnitInfo/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteUnitInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
		
}