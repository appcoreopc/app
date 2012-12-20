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

import com.appCore.personnel.Core.Job.Entity.Specialty;

import com.appCore.personnel.Core.Job.Service.SpecialtyService;


@Controller
@RequestMapping("/Job")
public class SpecialtyController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="specialtyService")
		private SpecialtyService service;

		@RequestMapping(value = "/Specialty/list", method = RequestMethod.GET)		
		public @ResponseBody List<Specialty> listSpecialty () 
		{
				List<Specialty> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Specialty/get", method = RequestMethod.GET)		
		public @ResponseBody Specialty getSpecialty (@RequestParam(value="id", required=true) Integer id ) 
		{
				Specialty specialty=service.get(id);
				return specialty;
		}

		@RequestMapping(value = "/Specialty/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddSpecialty (@RequestBody Specialty specialty)
		{
				service.add(specialty);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Specialty/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addSpecialty (@RequestBody Specialty specialty)
		{
				service.add(specialty);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Specialty/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateSpecialty (@RequestBody Specialty specialty)
		{
				service.saveOrUpdate(specialty);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Specialty/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteSpecialty (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}