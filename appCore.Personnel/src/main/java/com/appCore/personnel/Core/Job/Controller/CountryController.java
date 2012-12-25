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

import com.appCore.personnel.Core.Job.Service.CountryService;


@Controller
@RequestMapping("/Job")
public class CountryController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="countryService")
		private CountryService service;

		@RequestMapping(value = "/Country/list", method = RequestMethod.GET)		
		public @ResponseBody List<Country> listCountry () 
		{
				List<Country> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/Country/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Country> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<Country> list = service.getAllByCompany(id);
				return list;
		}

		
		@RequestMapping(value = "/Country/get", method = RequestMethod.GET)		
		public @ResponseBody Country getCountry (@RequestParam(value="id", required=true) Integer id ) 
		{
				Country country=service.get(id);
				return country;
		}

		@RequestMapping(value = "/Country/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddCountry (@RequestBody Country country)
		{
				service.add(country);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Country/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addCountry (@RequestBody Country country)
		{
				service.add(country);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Country/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateCountry (@RequestBody Country country)
		{
				service.saveOrUpdate(country);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Country/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteCountry (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}