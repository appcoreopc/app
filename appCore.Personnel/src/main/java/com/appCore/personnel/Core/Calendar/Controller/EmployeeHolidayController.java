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
import com.appCore.personnel.Core.Calendar.Entity.EmployeeHoliday;
import com.appCore.personnel.Core.Calendar.Service.EmployeeHolidayService;

@Controller
@RequestMapping("/Calendar")
public class EmployeeHolidayController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeHolidayService")
		private EmployeeHolidayService service;

		@RequestMapping(value = "/EmployeeHoliday/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeHoliday> listEmployeeHoliday () 
		{
				List<EmployeeHoliday> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/EmployeeHoliday/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeHoliday> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeHoliday> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/EmployeeHoliday/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeHoliday getEmployeeHoliday (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeHoliday employeeHoliday=service.get(id);
				return employeeHoliday;
		}

		@RequestMapping(value = "/EmployeeHoliday/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeHoliday (@RequestBody EmployeeHoliday employeeHoliday)
		{
				service.add(employeeHoliday);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeHoliday/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeHoliday (@RequestBody EmployeeHoliday employeeHoliday)
		{
				service.add(employeeHoliday);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeHoliday/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeHoliday (@RequestBody EmployeeHoliday employeeHoliday)
		{
				service.saveOrUpdate(employeeHoliday);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeHoliday/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeHoliday (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}