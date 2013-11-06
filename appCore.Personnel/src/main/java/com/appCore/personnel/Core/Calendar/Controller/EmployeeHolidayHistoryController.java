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
import com.appCore.personnel.Core.Calendar.Entity.EmployeeHolidayHistory;
import com.appCore.personnel.Core.Calendar.Service.EmployeeHolidayHistoryService;

@Controller
@RequestMapping("/Calendar")
public class EmployeeHolidayHistoryController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employeeHolidayHistoryService")
		private EmployeeHolidayHistoryService service;

		@RequestMapping(value = "/EmployeeHolidayHistory/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeHolidayHistory> listEmployeeHolidayHistory () 
		{
				List<EmployeeHolidayHistory> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/EmployeeHolidayHistory/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeHolidayHistory> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<EmployeeHolidayHistory> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/EmployeeHolidayHistory/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeHolidayHistory getEmployeeHolidayHistory (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeHolidayHistory employeeHolidayHistory=service.get(id);
				return employeeHolidayHistory;
		}

		@RequestMapping(value = "/EmployeeHolidayHistory/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddEmployeeHolidayHistory (@RequestBody EmployeeHolidayHistory employeeHolidayHistory)
		{
				service.add(employeeHolidayHistory);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeHolidayHistory/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addEmployeeHolidayHistory (@RequestBody EmployeeHolidayHistory employeeHolidayHistory)
		{
				service.add(employeeHolidayHistory);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeHolidayHistory/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateEmployeeHolidayHistory (@RequestBody EmployeeHolidayHistory employeeHolidayHistory)
		{
				service.saveOrUpdate(employeeHolidayHistory);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/EmployeeHolidayHistory/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteEmployeeHolidayHistory (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}