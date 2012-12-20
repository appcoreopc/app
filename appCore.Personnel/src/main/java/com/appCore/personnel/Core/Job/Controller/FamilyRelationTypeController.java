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

import com.appCore.personnel.Core.Job.Entity.FamilyRelationType;

import com.appCore.personnel.Core.Job.Service.FamilyRelationTypeService;


@Controller
@RequestMapping("/Job")
public class FamilyRelationTypeController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="familyRelationTypeService")
		private FamilyRelationTypeService service;

		@RequestMapping(value = "/FamilyRelationType/list", method = RequestMethod.GET)		
		public @ResponseBody List<FamilyRelationType> listFamilyRelationType () 
		{
				List<FamilyRelationType> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/FamilyRelationType/get", method = RequestMethod.GET)		
		public @ResponseBody FamilyRelationType getFamilyRelationType (@RequestParam(value="id", required=true) Integer id ) 
		{
				FamilyRelationType familyRelationType=service.get(id);
				return familyRelationType;
		}

		@RequestMapping(value = "/FamilyRelationType/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddFamilyRelationType (@RequestBody FamilyRelationType familyRelationType)
		{
				service.add(familyRelationType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/FamilyRelationType/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addFamilyRelationType (@RequestBody FamilyRelationType familyRelationType)
		{
				service.add(familyRelationType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/FamilyRelationType/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateFamilyRelationType (@RequestBody FamilyRelationType familyRelationType)
		{
				service.saveOrUpdate(familyRelationType);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/FamilyRelationType/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteFamilyRelationType (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}