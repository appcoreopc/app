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

import com.appCore.personnel.Core.Job.Entity.MaritalStatus;

import com.appCore.personnel.Core.Job.Service.MaritalStatusService;


@Controller
@RequestMapping("/Job")
public class MaritalStatusController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="maritalStatusService")
		private MaritalStatusService service;

		@RequestMapping(value = "/MaritalStatus/list", method = RequestMethod.GET)		
		public @ResponseBody List<MaritalStatus> listMaritalStatus () 
		{
				List<MaritalStatus> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/MaritalStatus/get", method = RequestMethod.GET)		
		public @ResponseBody MaritalStatus getMaritalStatus (@RequestParam(value="id", required=true) Integer id ) 
		{
				MaritalStatus maritalStatus=service.get(id);
				return maritalStatus;
		}

		@RequestMapping(value = "/MaritalStatus/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddMaritalStatus (@RequestBody MaritalStatus maritalStatus)
		{
				service.add(maritalStatus);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/MaritalStatus/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addMaritalStatus (@RequestBody MaritalStatus maritalStatus)
		{
				service.add(maritalStatus);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/MaritalStatus/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateMaritalStatus (@RequestBody MaritalStatus maritalStatus)
		{
				service.saveOrUpdate(maritalStatus);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/MaritalStatus/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteMaritalStatus (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}