package com.appCore.personnel.Core.Job.Controller;

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

import com.appCore.personnel.Core.Job.Entity.Country;
import com.appCore.personnel.Core.Job.Entity.Currency;

import com.appCore.personnel.Core.Job.Service.CurrencyService;


@Controller
@RequestMapping("/Job")
public class CurrencyController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="currencyService")
		private CurrencyService service;

		@RequestMapping(value = "/Currency/list", method = RequestMethod.GET)		
		public @ResponseBody List<Currency> listCurrency () 
		{
				List<Currency> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/Currency/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Currency> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<Currency> list = service.getAllByCompany(id);
				return list;
		}
		

		@RequestMapping(value = "/Currency/get", method = RequestMethod.GET)		
		public @ResponseBody Currency getCurrency (@RequestParam(value="id", required=true) Integer id ) 
		{
				Currency currency=service.get(id);
				return currency;
		}

		@RequestMapping(value = "/Currency/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddCurrency (@RequestBody Currency currency)
		{
				service.add(currency);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Currency/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addCurrency (@RequestBody Currency currency)
		{
				service.add(currency);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Currency/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateCurrency (@RequestBody Currency currency)
		{
				service.saveOrUpdate(currency);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Currency/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteCurrency (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}