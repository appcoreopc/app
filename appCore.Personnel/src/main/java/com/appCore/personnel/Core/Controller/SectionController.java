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
import com.appCore.personnel.Core.Entity.DivisionSummary;
import com.appCore.personnel.Core.Entity.Section;
import com.appCore.personnel.Core.Entity.SectionSummary;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.SectionService;


@Controller
@RequestMapping("/Core")
public class SectionController
{ 
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="sectionService")
		private SectionService service;

		
		@RequestMapping(value = "/Section/getSummary", method = RequestMethod.GET)		
		public @ResponseBody SectionSummary getSummary (@RequestParam(value="id", required=true) Integer id) 
		{
			return service.getSummary(id);
		}
		
		@RequestMapping(value = "/Section/list", method = RequestMethod.GET)		
		public @ResponseBody List<Section> listSection ( Model model ) 
		{
				List<Section> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}

		@RequestMapping(value = "/Section/get", method = RequestMethod.GET)		
		public @ResponseBody Section getSection (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				Section section=service.get(id);
				model.addAttribute("modelData", section);
				return section;
		}

		@RequestMapping(value = "/Section/add", method = RequestMethod.GET)
		public String renderAddSection ( Model model ) 
		{
				model.addAttribute("modelData", new Section());
				return "View/Core/Section/add";
		}

		@RequestMapping(value = "/Section/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addSection (@RequestBody Section section)
		{
				service.add(section);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Section/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateSection (@RequestBody Section section)
		{
				service.saveOrUpdate(section);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Section/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteSection (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/Section/edit", method = RequestMethod.GET)
		public String editSection ( Model model ) 
		{
				return "View/Core/Section/edit";
		}


}