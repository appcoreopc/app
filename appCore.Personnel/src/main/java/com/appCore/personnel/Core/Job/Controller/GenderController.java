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

import com.appCore.personnel.Core.Job.Entity.Gender;

import com.appCore.personnel.Core.Job.Service.GenderService;


@Controller
@RequestMapping("/Job")
public class GenderController
{ 
	
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="genderService")
		private GenderService service;

		@RequestMapping(value = "/Gender/list", method = RequestMethod.GET)		
		public @ResponseBody List<Gender> listGender () 
		{
				List<Gender> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Gender/get", method = RequestMethod.GET)		
		public @ResponseBody Gender getGender (@RequestParam(value="id", required=true) Integer id ) 
		{
				Gender gender=service.get(id);
				return gender;
		}

		@RequestMapping(value = "/Gender/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddGender (@RequestBody Gender gender)
		{
				service.add(gender);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
			
		@RequestMapping(value = "/Gender/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addGender (@RequestBody Gender gender)
		{
				service.add(gender);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Gender/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateGender (@RequestBody Gender gender)
		{
				service.saveOrUpdate(gender);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Gender/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteGender (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}