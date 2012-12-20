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

import com.appCore.Requests.RequestStatus;
import com.appCore.personnel.Core.Entity.SectionInfo;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.SectionInfoService;


@Controller
@RequestMapping("/Core")
public class SectionInfoController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="sectionInfoService")
		private SectionInfoService service;

		@RequestMapping(value = "/SectionInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<SectionInfo> listSectionInfo ( Model model ) 
		{
				List<SectionInfo> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/SectionInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<SectionInfo> listSectionInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<SectionInfo> list = service.getAllByRefEntity(id);
				return list;
		}

		@RequestMapping(value = "/SectionInfo/get", method = RequestMethod.GET)		
		public @ResponseBody SectionInfo getSectionInfo (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				SectionInfo sectionInfo=service.get(id);
				model.addAttribute("modelData", sectionInfo);
				return sectionInfo;
		}

		@RequestMapping(value = "/SectionInfo/add", method = RequestMethod.GET)
		public String renderAddSectionInfo ( Model model ) 
		{
				model.addAttribute("modelData", new SectionInfo());
				return "View/Core/SectionInfo/add";
		}

		@RequestMapping(value = "/SectionInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addSectionInfo (@ModelAttribute SectionInfo sectionInfo)
		{
				service.add(sectionInfo);
				return "View/Core/SectionInfo/add";
		}

		@RequestMapping(value = "/SectionInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateSectionInfo (@RequestBody SectionInfo sectionInfo)
		{
				service.saveOrUpdate(sectionInfo);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/SectionInfo/delete", method = RequestMethod.GET)
		public @ResponseBody String deleteSectionInfo (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);

				return "View/Core/SectionInfo/delete";
		}

		@RequestMapping(value = "/SectionInfo/edit", method = RequestMethod.GET)
		public String editSectionInfo ( Model model ) 
		{
				return "View/Core/SectionInfo/edit";
		}


}