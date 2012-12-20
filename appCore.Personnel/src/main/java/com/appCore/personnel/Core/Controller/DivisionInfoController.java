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

import com.appCore.personnel.Core.Entity.DivisionInfo;

import com.appCore.personnel.Core.Service.DivisionInfoService;


@Controller
@RequestMapping("/Core")
public class DivisionInfoController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="divisionInfoService")
		private DivisionInfoService service;

		@RequestMapping(value = "/DivisionInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<DivisionInfo> listDivisionInfo ( Model model ) 
		{
				List<DivisionInfo> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/DivisionInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<DivisionInfo> listDivisionInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<DivisionInfo> list = service.getAllByRefEntity(id);
				return list;
		}
	
		@RequestMapping(value = "/DivisionInfo/get", method = RequestMethod.GET)		
		public @ResponseBody DivisionInfo getDivisionInfo (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				DivisionInfo divisionInfo=service.get(id);
				model.addAttribute("modelData", divisionInfo);
				return divisionInfo;
		}

		@RequestMapping(value = "/DivisionInfo/add", method = RequestMethod.GET)
		public String renderAddDivisionInfo ( Model model ) 
		{
				model.addAttribute("modelData", new DivisionInfo());
				return "View/Core/DivisionInfo/add";
		}

		@RequestMapping(value = "/DivisionInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addDivisionInfo (@ModelAttribute DivisionInfo divisionInfo)
		{
				service.add(divisionInfo);
				return "View/Core/DivisionInfo/add";
		}

		@RequestMapping(value = "/DivisionInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody String saveOrUpdateDivisionInfo (@ModelAttribute DivisionInfo divisionInfo)
		{
				service.saveOrUpdate(divisionInfo);
				return "View/Core/DivisionInfo/add";
		}

		@RequestMapping(value = "/DivisionInfo/delete", method = RequestMethod.GET)
		public @ResponseBody String deleteDivisionInfo (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);

				return "View/Core/DivisionInfo/delete";
		}

		@RequestMapping(value = "/DivisionInfo/edit", method = RequestMethod.GET)
		public String editDivisionInfo ( Model model ) 
		{
				return "View/Core/DivisionInfo/edit";
		}

}