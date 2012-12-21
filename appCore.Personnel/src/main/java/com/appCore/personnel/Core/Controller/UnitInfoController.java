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

import com.appCore.personnel.Core.Entity.UnitInfo;

import com.appCore.personnel.Core.Service.UnitInfoService;


@Controller
@RequestMapping("/Core")
public class UnitInfoController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="unitInfoService")
		private UnitInfoService service;

		@RequestMapping(value = "/UnitInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<UnitInfo> listUnitInfo ( Model model ) 
		{
				List<UnitInfo> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/UnitInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<UnitInfo> listUnitInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<UnitInfo> list = service.getAllByRefEntity(id);
				return list;
		}

		@RequestMapping(value = "/UnitInfo/get", method = RequestMethod.GET)		
		public @ResponseBody UnitInfo getUnitInfo (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				UnitInfo unitInfo=service.get(id);
				model.addAttribute("modelData", unitInfo);
				return unitInfo;
		}

		@RequestMapping(value = "/UnitInfo/add", method = RequestMethod.GET)
		public String renderAddUnitInfo ( Model model ) 
		{
				model.addAttribute("modelData", new UnitInfo());
				return "View/Core/UnitInfo/add";
		}

		@RequestMapping(value = "/UnitInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addUnitInfo (@ModelAttribute UnitInfo unitInfo)
		{
				service.add(unitInfo);
				return "View/Core/UnitInfo/add";
		}

		@RequestMapping(value = "/UnitInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody String saveOrUpdateUnitInfo (@ModelAttribute UnitInfo unitInfo)
		{
				service.saveOrUpdate(unitInfo);
				return "View/Core/UnitInfo/add";
		}

		@RequestMapping(value = "/UnitInfo/delete", method = RequestMethod.GET)
		public @ResponseBody String deleteUnitInfo (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);

				return "View/Core/UnitInfo/delete";
		}

		@RequestMapping(value = "/UnitInfo/edit", method = RequestMethod.GET)
		public String editUnitInfo ( Model model ) 
		{
				return "View/Core/UnitInfo/edit";
		}


}