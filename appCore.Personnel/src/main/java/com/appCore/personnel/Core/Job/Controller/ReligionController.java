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

import com.appCore.personnel.Core.Job.Entity.Religion;

import com.appCore.personnel.Core.Job.Service.ReligionService;


@Controller
@RequestMapping("/Job")
public class ReligionController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="religionService")
		private ReligionService service;

		@RequestMapping(value = "/Religion/list", method = RequestMethod.GET)		
		public @ResponseBody List<Religion> listReligion () 
		{
				List<Religion> list = service.getAll();
				return list;
		}

		
		@RequestMapping(value = "/Religion/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Religion> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<Religion> list = service.getAllByCompany(id);
				return list;
		}

		
		@RequestMapping(value = "/Religion/get", method = RequestMethod.GET)		
		public @ResponseBody Religion getReligion (@RequestParam(value="id", required=true) Integer id ) 
		{
				Religion religion=service.get(id);
				return religion;
		}

		@RequestMapping(value = "/Religion/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddReligion (@RequestBody Religion religion)
		{
				service.add(religion);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Religion/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addReligion (@RequestBody Religion religion)
		{
				service.add(religion);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Religion/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateReligion (@RequestBody Religion religion)
		{
				service.saveOrUpdate(religion);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Religion/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteReligion (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}