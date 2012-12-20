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

import com.appCore.personnel.Core.Job.Entity.GradeInfo;

import com.appCore.personnel.Core.Job.Service.GradeInfoService;


@Controller
@RequestMapping("/Core/Job")
public class GradeInfoController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="gradeInfoService")
		private GradeInfoService service;

		@RequestMapping(value = "/GradeInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<GradeInfo> listGradeInfo ( Model model ) 
		{
				List<GradeInfo> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/GradeInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<GradeInfo> listGradeInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<GradeInfo> list = service.getAllByRefEntity(id);
				return list;
		}
		

		@RequestMapping(value = "/GradeInfo/get", method = RequestMethod.GET)		
		public @ResponseBody GradeInfo getGradeInfo (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				GradeInfo gradeInfo=service.get(id);
				model.addAttribute("modelData", gradeInfo);
				return gradeInfo;
		}

		@RequestMapping(value = "/GradeInfo/add", method = RequestMethod.GET)
		public String renderAddGradeInfo (@ModelAttribute GradeInfo gradeInfo)
		{
				service.add(gradeInfo);
				return "View/Job/GradeInfo/add";
		}

		@RequestMapping(value = "/GradeInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addGradeInfo (@ModelAttribute GradeInfo gradeInfo)
		{
				service.add(gradeInfo);
				return "View/Job/GradeInfo/add";
		}

		@RequestMapping(value = "/GradeInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody String saveOrUpdateGradeInfo (@ModelAttribute GradeInfo gradeInfo)
		{
				service.saveOrUpdate(gradeInfo);
				return "View/Job/GradeInfo/add";
		}

		@RequestMapping(value = "/GradeInfo/delete", method = RequestMethod.GET)
		public @ResponseBody String deleteGradeInfo (@RequestParam(value="id", required=true) Integer id, Model model )
		{
				service.delete(id);

				return "View/Job/GradeInfo/delete";
		}

		@RequestMapping(value = "/GradeInfo/edit", method = RequestMethod.GET)
		public String editGradeInfo ( Model model ) 
		{
				return "View/Job/GradeInfo/edit";
		}


}