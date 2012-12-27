package com.appCore.personnel.Core.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.appCore.personnel.Core.Entity.BranchSummary;
import com.appCore.personnel.Core.Entity.Department;
import com.appCore.personnel.Core.Entity.DepartmentSummary;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.Core.Service.DepartmentService;

@Controller
@RequestMapping("/Core")
public class DepartmentController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="departmentService")
		private DepartmentService service;

		@RequestMapping(value = "/Department/getSummary", method = RequestMethod.GET)		
		public @ResponseBody DepartmentSummary getSummary (@RequestParam(value="id", required=true) Integer id) 
		{
			return service.getSummary(id);
		}
		
		@RequestMapping(value = "/Department/list", method = RequestMethod.GET)		
		public @ResponseBody List<Department> listDepartment () 
		{
				List<Department> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/Department/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Department> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{	
				List<Department> list = service.getAllByCompany(id);
				return list;
		}
		
		
		@RequestMapping(value = "/Department/getByDivisionId", method = RequestMethod.GET)		
		public @ResponseBody List<Department> listDepartment (@RequestParam(value="Id", required=true) Integer id) 
		{
				List<Department> list = service.getByDivisionId(id);
				return list;
		}

		@RequestMapping(value = "/Department/get", method = RequestMethod.GET)		
		public @ResponseBody Department getDepartment (@RequestParam(value="id", required=true) Integer id) 
		{
				Department department=service.get(id);
				return department;
		}

		
		@RequestMapping(value = "/Department/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addDepartment (@RequestBody Department department)
		{
				service.add(department);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Department/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateDepartment (@RequestBody Department department)
		{
				service.saveOrUpdate(department);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}
		
		@RequestMapping(value = "/Department/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteDepartment (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);

				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

} 	