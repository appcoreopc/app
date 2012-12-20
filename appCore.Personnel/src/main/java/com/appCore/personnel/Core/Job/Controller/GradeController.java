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

import com.appCore.Requests.RequestStatus;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.Core.Job.Entity.Grade;

import com.appCore.personnel.Core.Job.Service.GradeService;


@Controller
@RequestMapping("/Core/Job")
public class GradeController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="gradeService")
		private GradeService service;

		@RequestMapping(value = "/Grade/list", method = RequestMethod.GET)		
		public @ResponseBody List<Grade> listGrade () 
		{
				List<Grade> list = service.getAll();
				return list;
		}
		

		@RequestMapping(value = "/Grade/get", method = RequestMethod.GET)		
		public @ResponseBody Grade getGrade (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				Grade grade=service.get(id);
				model.addAttribute("modelData", grade);
				return grade;
		}

		@RequestMapping(value = "/Grade/add", method = RequestMethod.GET)
		public String renderAddGrade (@ModelAttribute Grade grade)
		{
				service.add(grade);
				return "View/Job/Grade/add";
		}

		@RequestMapping(value = "/Grade/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addGrade (@RequestBody Grade grade)
		{
				service.add(grade);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Grade/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateGrade (@RequestBody Grade grade)
		{
				service.saveOrUpdate(grade);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Grade/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteGrade (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		@RequestMapping(value = "/Grade/edit", method = RequestMethod.GET)
		public String editGrade ( Model model ) 
		{
				return "View/Job/Grade/edit";
		}

}