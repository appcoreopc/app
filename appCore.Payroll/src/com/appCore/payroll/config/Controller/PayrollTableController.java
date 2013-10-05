package com.appCore.payroll.config.Controller;

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
import com.appCore.payroll.config.Entity.PayrollTable;
import com.appCore.payroll.config.Service.PayrollTableService;

@Controller
@RequestMapping("/config")
public class PayrollTableController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="payrollTableService")
		private PayrollTableService service;

		@RequestMapping(value = "/PayrollTable/list", method = RequestMethod.GET)		
		public @ResponseBody List<PayrollTable> listPayrollTable () 
		{
				List<PayrollTable> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/PayrollTable/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<PayrollTable> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<PayrollTable> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/PayrollTable/get", method = RequestMethod.GET)		
		public @ResponseBody PayrollTable getPayrollTable (@RequestParam(value="id", required=true) Integer id ) 
		{
				PayrollTable payrollTable=service.get(id);
				return payrollTable;
		}

		@RequestMapping(value = "/PayrollTable/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddPayrollTable (@RequestBody PayrollTable payrollTable)
		{
				service.add(payrollTable);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollTable/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addPayrollTable (@RequestBody PayrollTable payrollTable)
		{
				service.add(payrollTable);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollTable/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdatePayrollTable (@RequestBody PayrollTable payrollTable)
		{
				service.saveOrUpdate(payrollTable);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollTable/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deletePayrollTable (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}