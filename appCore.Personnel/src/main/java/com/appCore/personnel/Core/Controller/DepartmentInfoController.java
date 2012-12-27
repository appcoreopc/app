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
import com.appCore.personnel.Core.Entity.DepartmentInfo;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.DepartmentInfoService;


@Controller
@RequestMapping("/Core")
public class DepartmentInfoController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="departmentInfoService")
		private DepartmentInfoService service;

		@RequestMapping(value = "/DepartmentInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<DepartmentInfo> listDepartmentInfo () 
		{
				List<DepartmentInfo> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/DepartmentInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<DepartmentInfo> listDepartmentInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<DepartmentInfo> list = service.getAllByRefEntity(id);
				return list;
		}
		

		@RequestMapping(value = "/DepartmentInfo/get", method = RequestMethod.GET)		
		public @ResponseBody DepartmentInfo getDepartmentInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				DepartmentInfo departmentInfo=service.get(id);
				return departmentInfo;
		}

		
		@RequestMapping(value = "/DepartmentInfo/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addDepartmentInfo (@RequestBody DepartmentInfo departmentInfo)
		{
				service.add(departmentInfo);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/DepartmentInfo/saveOrUpdate", method = RequestMethod.POST)
		public  @ResponseBody RequestStatus saveOrUpdateDepartmentInfo (@RequestBody DepartmentInfo departmentInfo)
		{
				int saveId = service.saveOrUpdate(departmentInfo);
				RequestStatus status = RequestStatusHelper.GenerateRequestStatusSaveOperation();
				status.setSaveCode(saveId);
				return status;
		}

		@RequestMapping(value = "/DepartmentInfo/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteDepartmentInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

}