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

import com.appCore.personnel.Core.Job.Entity.Salutation;

import com.appCore.personnel.Core.Job.Service.SalutationService;


@Controller
@RequestMapping("/Job")
public class SalutationController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="salutationService")
		private SalutationService service;

		@RequestMapping(value = "/Salutation/list", method = RequestMethod.GET)		
		public @ResponseBody List<Salutation> listSalutation () 
		{
				List<Salutation> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Salutation/get", method = RequestMethod.GET)		
		public @ResponseBody Salutation getSalutation (@RequestParam(value="id", required=true) Integer id ) 
		{
				Salutation salutation=service.get(id);
				return salutation;
		}

		@RequestMapping(value = "/Salutation/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddSalutation (@RequestBody Salutation salutation)
		{
				service.add(salutation);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Salutation/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addSalutation (@RequestBody Salutation salutation)
		{
				service.add(salutation);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Salutation/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateSalutation (@RequestBody Salutation salutation)
		{
				service.saveOrUpdate(salutation);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Salutation/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteSalutation (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}