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

import com.appCore.personnel.Core.Job.Entity.FieldOfExpertise;

import com.appCore.personnel.Core.Job.Service.FieldOfExpertiseService;


@Controller
@RequestMapping("/Job")
public class FieldOfExpertiseController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="fieldOfExpertiseService")
		private FieldOfExpertiseService service;

		@RequestMapping(value = "/FieldOfExpertise/list", method = RequestMethod.GET)		
		public @ResponseBody List<FieldOfExpertise> listFieldOfExpertise () 
		{
				List<FieldOfExpertise> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/FieldOfExpertise/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<FieldOfExpertise> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<FieldOfExpertise> list = service.getAllByCompany(id);
				return list;
		}
				
		@RequestMapping(value = "/FieldOfExpertise/get", method = RequestMethod.GET)		
		public @ResponseBody FieldOfExpertise getFieldOfExpertise (@RequestParam(value="id", required=true) Integer id ) 
		{
				FieldOfExpertise fieldOfExpertise=service.get(id);
				return fieldOfExpertise;
		}

		@RequestMapping(value = "/FieldOfExpertise/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddFieldOfExpertise (@RequestBody FieldOfExpertise fieldOfExpertise)
		{
				service.add(fieldOfExpertise);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/FieldOfExpertise/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addFieldOfExpertise (@RequestBody FieldOfExpertise fieldOfExpertise)
		{
				service.add(fieldOfExpertise);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/FieldOfExpertise/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateFieldOfExpertise (@RequestBody FieldOfExpertise fieldOfExpertise)
		{
				service.saveOrUpdate(fieldOfExpertise);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/FieldOfExpertise/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteFieldOfExpertise (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}