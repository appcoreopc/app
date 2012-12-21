package com.appCore.personnel.Core.Controller;

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

import com.appCore.personnel.Core.Entity.DepartmentInfo;

import com.appCore.personnel.Core.Service.DepartmentInfoService;


@Controller
@RequestMapping("/Core")
public class DepartmentInfoController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="departmentInfoService")
		private DepartmentInfoService service;

		@RequestMapping(value = "/DepartmentInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<DepartmentInfo> listDepartmentInfo ( Model model ) 
		{
				List<DepartmentInfo> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/DepartmentInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<DepartmentInfo> listDepartmentInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<DepartmentInfo> list = service.getAllByRefEntity(id);
				return list;
		}
		

		@RequestMapping(value = "/DepartmentInfo/get", method = RequestMethod.GET)		
		public @ResponseBody DepartmentInfo getDepartmentInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				DepartmentInfo departmentInfo=service.get(id);
				return departmentInfo;
		}

		@RequestMapping(value = "/DepartmentInfo/add", method = RequestMethod.GET)
		public String renderAddDepartmentInfo ( Model model ) 
		{
				model.addAttribute("modelData", new DepartmentInfo());
				return "View/Core/DepartmentInfo/add";
		}

		@RequestMapping(value = "/DepartmentInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addDepartmentInfo (@ModelAttribute DepartmentInfo departmentInfo)
		{
				service.add(departmentInfo);
				return "View/Core/DepartmentInfo/add";
		}

		@RequestMapping(value = "/DepartmentInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody String saveOrUpdateDepartmentInfo (@ModelAttribute DepartmentInfo departmentInfo)
		{
				service.saveOrUpdate(departmentInfo);
				return "View/Core/DepartmentInfo/add";
		}

		@RequestMapping(value = "/DepartmentInfo/delete", method = RequestMethod.GET)
		public @ResponseBody String deleteDepartmentInfo (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);

				return "View/Core/DepartmentInfo/delete";
		}

		@RequestMapping(value = "/DepartmentInfo/edit", method = RequestMethod.GET)
		public String editDepartmentInfo ( Model model ) 
		{
				return "View/Core/DepartmentInfo/edit";
		}

}