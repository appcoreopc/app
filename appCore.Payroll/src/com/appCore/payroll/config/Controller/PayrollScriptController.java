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
import com.appCore.payroll.config.Entity.PayrollScript;
import com.appCore.payroll.config.Service.PayrollScriptService;

@Controller
@RequestMapping("/Payroll/config")
public class PayrollScriptController
{ 	
		
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="payrollScriptService")
		private PayrollScriptService service;
		
		@RequestMapping(value = "/PayrollScript/list", method = RequestMethod.GET)		
		public @ResponseBody List<PayrollScript> listPayrollScript () 
		{
				List<PayrollScript> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/PayrollScript/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<PayrollScript> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<PayrollScript> list = service.getAllByCompany(id);
				return list;
		}
		
		@RequestMapping(value = "/PayrollScript/get", method = RequestMethod.GET)		
		public @ResponseBody PayrollScript getPayrollScript (@RequestParam(value="id", required=true) Integer id ) 
		{
				PayrollScript payrollScript=service.get(id);
				return payrollScript;
		}

		@RequestMapping(value = "/PayrollScript/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddPayrollScript (@RequestBody PayrollScript payrollScript)
		{
				service.add(payrollScript);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollScript/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addPayrollScript (@RequestBody PayrollScript payrollScript)
		{
				service.add(payrollScript);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollScript/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdatePayrollScript (@RequestBody PayrollScript payrollScript)
		{
				service.saveOrUpdate(payrollScript);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollScript/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deletePayrollScript (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}