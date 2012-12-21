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

import com.appCore.personnel.Core.Job.Entity.EmploymentTypeInfo;

import com.appCore.personnel.Core.Job.Service.EmploymentTypeInfoService;


@Controller
@RequestMapping("/Core/Job")
public class EmploymentTypeInfoController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="employmentTypeInfoService")
		private EmploymentTypeInfoService service;

		@RequestMapping(value = "/EmploymentTypeInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<EmploymentTypeInfo> listEmploymentTypeInfo ( Model model ) 
		{
				List<EmploymentTypeInfo> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/EmploymentTypeInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<EmploymentTypeInfo> listEmploymentTypeInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<EmploymentTypeInfo> list = service.getAllByRefEntity(id);
				return list;
		}

		@RequestMapping(value = "/EmploymentTypeInfo/get", method = RequestMethod.GET)		
		public @ResponseBody EmploymentTypeInfo getEmploymentTypeInfo (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				EmploymentTypeInfo employmentTypeInfo=service.get(id);
				model.addAttribute("modelData", employmentTypeInfo);
				return employmentTypeInfo;
		}

		@RequestMapping(value = "/EmploymentTypeInfo/add", method = RequestMethod.GET)
		public String renderAddEmploymentTypeInfo (@ModelAttribute EmploymentTypeInfo employmentTypeInfo)
		{
				service.add(employmentTypeInfo);
				return "View/Job/EmploymentTypeInfo/add";
		}

		@RequestMapping(value = "/EmploymentTypeInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addEmploymentTypeInfo (@ModelAttribute EmploymentTypeInfo employmentTypeInfo)
		{
				service.add(employmentTypeInfo);
				return "View/Job/EmploymentTypeInfo/add";
		}

		@RequestMapping(value = "/EmploymentTypeInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody String saveOrUpdateEmploymentTypeInfo (@ModelAttribute EmploymentTypeInfo employmentTypeInfo)
		{
				service.saveOrUpdate(employmentTypeInfo);
				return "View/Job/EmploymentTypeInfo/add";
		}

		@RequestMapping(value = "/EmploymentTypeInfo/delete", method = RequestMethod.GET)
		public @ResponseBody String deleteEmploymentTypeInfo (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);

				return "View/Job/EmploymentTypeInfo/delete";
		}

		@RequestMapping(value = "/EmploymentTypeInfo/edit", method = RequestMethod.GET)
		public String editEmploymentTypeInfo ( Model model ) 
		{
				return "View/Job/EmploymentTypeInfo/edit";
		}

}