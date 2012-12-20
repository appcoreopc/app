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
import com.appCore.personnel.Core.Entity.Company;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.Core.Service.CompanyService;


@Controller
@RequestMapping("/Core")
public class CompanyController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="companyService")
		private CompanyService service;

		@RequestMapping(value = "/Company/getSummary", method = RequestMethod.GET)		
		public @ResponseBody Integer listCompany (@RequestParam(value="id", required=true) Integer id) 
		{
				return service.getSummary(id);
		}
		
		
		@RequestMapping(value = "/Company/list", method = RequestMethod.GET)		
		public @ResponseBody List<Company> listCompany() 
		{
				List<Company> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Company/get", method = RequestMethod.GET)		
		public @ResponseBody Company getCompany (@RequestParam(value="id", required=true) Integer id) 
		{
				Company company=service.get(id);
				return company;
		}

		@RequestMapping(value = "/Company/add", method = RequestMethod.GET)
		public String renderAddCompany (@ModelAttribute Company company)
		{
				service.add(company);
				return "View/Core/Company/add";
		}

		@RequestMapping(value = "/Company/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addCompany (@RequestBody Company company)
		{
				service.add(company);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Company/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateCompany (@RequestBody Company company)
		{
				service.saveOrUpdate(company);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Company/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteCompany (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/Company/edit", method = RequestMethod.GET)
		public String editCompany ( Model model ) 
		{
				return "View/Core/Company/edit";
		}

}