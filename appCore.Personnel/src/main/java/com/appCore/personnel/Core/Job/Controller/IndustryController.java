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

import com.appCore.personnel.Core.Job.Entity.Industry;

import com.appCore.personnel.Core.Job.Service.IndustryService;


@Controller
@RequestMapping("/Job")
public class IndustryController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="industryService")
		private IndustryService service;

		@RequestMapping(value = "/Industry/list", method = RequestMethod.GET)		
		public @ResponseBody List<Industry> listIndustry () 
		{
				List<Industry> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Industry/get", method = RequestMethod.GET)		
		public @ResponseBody Industry getIndustry (@RequestParam(value="id", required=true) Integer id ) 
		{
				Industry industry=service.get(id);
				return industry;
		}

		@RequestMapping(value = "/Industry/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddIndustry (@RequestBody Industry industry)
		{
				service.add(industry);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Industry/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addIndustry (@RequestBody Industry industry)
		{
				service.add(industry);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Industry/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateIndustry (@RequestBody Industry industry)
		{
				service.saveOrUpdate(industry);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Industry/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteIndustry (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}