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

import com.appCore.personnel.Core.Job.Entity.EmployeeAssociation;

import com.appCore.personnel.Core.Job.Service.AssociationService;


@Controller
@RequestMapping("/Job")
public class AssociationController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="associationService")
		private AssociationService service;

		@RequestMapping(value = "/Association/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmployeeAssociation> listAssociation () 
		{
				List<EmployeeAssociation> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Association/get", method = RequestMethod.GET)		
		public @ResponseBody EmployeeAssociation getAssociation (@RequestParam(value="id", required=true) Integer id ) 
		{
				EmployeeAssociation association=service.get(id);
				return association;
		}

		@RequestMapping(value = "/Association/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddAssociation (@RequestBody EmployeeAssociation association)
		{
				service.add(association);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Association/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addAssociation (@RequestBody EmployeeAssociation association)
		{
				service.add(association);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Association/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateAssociation (@RequestBody EmployeeAssociation association)
		{
				service.saveOrUpdate(association);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Association/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteAssociation (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}