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

import com.appCore.personnel.Core.Job.Entity.AssociationMembershipType;

import com.appCore.personnel.Core.Job.Service.AssociationMembershipTypeService;


@Controller
@RequestMapping("/Job")
public class AssociationMembershipTypeController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="associationMembershipTypeService")
		private AssociationMembershipTypeService service;

		@RequestMapping(value = "/AssociationMembershipType/list", method = RequestMethod.GET)		
		public @ResponseBody List<AssociationMembershipType> listAssociationMembershipType () 
		{
				List<AssociationMembershipType> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/AssociationMembershipType/get", method = RequestMethod.GET)		
		public @ResponseBody AssociationMembershipType getAssociationMembershipType (@RequestParam(value="id", required=true) Integer id ) 
		{
				AssociationMembershipType associationMembershipType=service.get(id);
				return associationMembershipType;
		}

		@RequestMapping(value = "/AssociationMembershipType/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddAssociationMembershipType (@RequestBody AssociationMembershipType associationMembershipType)
		{
				service.add(associationMembershipType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/AssociationMembershipType/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addAssociationMembershipType (@RequestBody AssociationMembershipType associationMembershipType)
		{
				service.add(associationMembershipType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/AssociationMembershipType/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateAssociationMembershipType (@RequestBody AssociationMembershipType associationMembershipType)
		{
				service.saveOrUpdate(associationMembershipType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/AssociationMembershipType/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteAssociationMembershipType (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}