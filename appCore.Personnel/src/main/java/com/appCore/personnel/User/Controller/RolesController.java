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
import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.User.Entity.Roles;

import com.appCore.personnel.User.Service.RolesService;


@Controller
@RequestMapping("/User")
public class RolesController
{ 	
		protected static Logger logger = Logger.getLogger("controller");
		
		@Resource(name="rolesService")
		private RolesService service;

		@RequestMapping(value = "/Roles/list", method = RequestMethod.GET)		
		public @ResponseBody List<Roles> listRoles () 
		{
				List<Roles> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Roles/listByCompany", method = RequestMethod.GET)
		public @ResponseBody
		List<Roles> listByCompany(
				@RequestParam(value = "id", required = true) Integer id) {
			List<Roles> list = service.getAllByCompany(id);
			return list;
		}

		
		@RequestMapping(value = "/Roles/get", method = RequestMethod.GET)		
		public @ResponseBody Roles getRoles (@RequestParam(value="id", required=true) Integer id ) 
		{
				Roles roles=service.get(id);
				return roles;
		}

		@RequestMapping(value = "/Roles/configuredRole", method = RequestMethod.GET)		
		public @ResponseBody RequestStatus saveconfiguredRole (@RequestParam(value="employeeId", required=true) int employeeId, int groupId, boolean isGrantAccess) 
		{
				service.saveconfiguredRole(employeeId, groupId, isGrantAccess);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		
		@RequestMapping(value = "/Roles/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddRoles (@RequestBody Roles roles)
		{
				service.add(roles);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Roles/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addRoles (@RequestBody Roles roles)
		{
				service.add(roles);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Roles/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateRoles (@RequestBody Roles roles)
		{
				service.saveOrUpdate(roles);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Roles/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteRoles (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

}