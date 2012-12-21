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

import com.appCore.personnel.Core.Job.Entity.Nationality;

import com.appCore.personnel.Core.Job.Service.NationalityService;


@Controller
@RequestMapping("/Job")
public class NationalityController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="nationalityService")
		private NationalityService service;

		@RequestMapping(value = "/Nationality/list", method = RequestMethod.GET)		
		public @ResponseBody List<Nationality> listNationality () 
		{
				List<Nationality> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Nationality/get", method = RequestMethod.GET)		
		public @ResponseBody Nationality getNationality (@RequestParam(value="id", required=true) Integer id ) 
		{
				Nationality nationality=service.get(id);
				return nationality;
		}

		@RequestMapping(value = "/Nationality/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddNationality (@RequestBody Nationality nationality)
		{
				service.add(nationality);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Nationality/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addNationality (@RequestBody Nationality nationality)
		{
				service.add(nationality);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Nationality/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateNationality (@RequestBody Nationality nationality)
		{
				service.saveOrUpdate(nationality);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Nationality/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteNationality (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}