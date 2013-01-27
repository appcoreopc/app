package com.appCore.personnel.Core.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appCore.personnel.Core.Entity.CompanyEntity;
import com.appCore.personnel.Core.Service.CompanyEntityService;


@Controller
@RequestMapping("/Core")
public class CompanyEntityController {

	protected static Logger logger = Logger.getLogger("controller");
	@Resource(name="companyEntityService")
	private CompanyEntityService service;
	
	
	@RequestMapping(value = "/CompanyEntity/list", method = RequestMethod.GET)		
	public @ResponseBody List<CompanyEntity> getAllEntity() 
	{
		 return service.getAllEntity();
	}
	
	@RequestMapping(value = "/CompanyEntity/listBy", method = RequestMethod.GET)		
	public @ResponseBody String getByCompanyId(Integer id) 
	{
			return "";
	}
}
