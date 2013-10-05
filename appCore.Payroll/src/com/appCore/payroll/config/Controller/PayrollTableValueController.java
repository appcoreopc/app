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
import com.appCore.payroll.config.Entity.PayrollTableValue;
import com.appCore.payroll.config.Service.PayrollTableValueService;

@Controller
@RequestMapping("/config")
public class PayrollTableValueController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="payrollTableValueService")
		private PayrollTableValueService service;

		@RequestMapping(value = "/PayrollTableValue/list", method = RequestMethod.GET)		
		public @ResponseBody List<PayrollTableValue> listPayrollTableValue () 
		{
				List<PayrollTableValue> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/PayrollTableValue/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<PayrollTableValue> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<PayrollTableValue> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/PayrollTableValue/get", method = RequestMethod.GET)		
		public @ResponseBody PayrollTableValue getPayrollTableValue (@RequestParam(value="id", required=true) Integer id ) 
		{
				PayrollTableValue payrollTableValue=service.get(id);
				return payrollTableValue;
		}

		@RequestMapping(value = "/PayrollTableValue/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddPayrollTableValue (@RequestBody PayrollTableValue payrollTableValue)
		{
				service.add(payrollTableValue);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollTableValue/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addPayrollTableValue (@RequestBody PayrollTableValue payrollTableValue)
		{
				service.add(payrollTableValue);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollTableValue/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdatePayrollTableValue (@RequestBody PayrollTableValue payrollTableValue)
		{
				service.saveOrUpdate(payrollTableValue);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/PayrollTableValue/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deletePayrollTableValue (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}