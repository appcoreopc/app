package com.appCore.personnel.User.Controller;

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

import com.appCore.personnel.User.Entity.Forms_Role;

import com.appCore.personnel.User.Service.Forms_RoleService;


@Controller
@RequestMapping("/User")
public class Forms_RoleController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="forms_RoleService")
		private Forms_RoleService service;

		@RequestMapping(value = "/Forms_Role/list", method = RequestMethod.GET)		
		public @ResponseBody List<Forms_Role> listForms_Role () 
		{
				List<Forms_Role> list = service.getAll();
				return list;
		}

		
		@RequestMapping(value = "/Forms_Role/getRoleById", method = RequestMethod.GET)		
		public @ResponseBody List<Forms_Role> listForms_Role (@RequestParam(value="id", required=true) Integer roleId) 
		{
				List<Forms_Role> list = service.getByRoles(roleId);
				return list;
		}

		
		@RequestMapping(value = "/Forms_Role/get", method = RequestMethod.GET)		
		public @ResponseBody Forms_Role getForms_Role (@RequestParam(value="id", required=true) Integer id ) 
		{
				Forms_Role forms_Role=service.get(id);
				return forms_Role;
		}

		@RequestMapping(value = "/Forms_Role/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddForms_Role (@RequestBody Forms_Role forms_Role)
		{
				service.add(forms_Role);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Forms_Role/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addForms_Role (@RequestBody Forms_Role forms_Role)
		{
				service.add(forms_Role);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Forms_Role/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateForms_Role (@RequestBody Forms_Role forms_Role)
		{
				service.saveOrUpdate(forms_Role);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Forms_Role/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteForms_Role (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}