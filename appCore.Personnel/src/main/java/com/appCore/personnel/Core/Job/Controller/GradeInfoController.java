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
		public @ResponseBody List<GradeInfo> listGradeInfo () 
		{
				List<GradeInfo> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/GradeInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<GradeInfo> listGradeInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<GradeInfo> list = service.getAllByRefEntity(id);
				return list;
		}
		

		@RequestMapping(value = "/GradeInfo/get", method = RequestMethod.GET)		
		public @ResponseBody GradeInfo getGradeInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				GradeInfo gradeInfo=service.get(id);
				return gradeInfo;
		}

		
		@RequestMapping(value = "/GradeInfo/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addGradeInfo (@ModelAttribute GradeInfo gradeInfo)
		{
				service.add(gradeInfo);
				return RequestStatusHelper.GenerateRequestStatusCreateOperation();
		}

		@RequestMapping(value = "/GradeInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateGradeInfo (@RequestBody GradeInfo gradeInfo)
		{
				int saveId = service.saveOrUpdate(gradeInfo);
				RequestStatus status = RequestStatusHelper.GenerateRequestStatusSaveOperation();
				status.setSaveCode(saveId);
				return status;
		}

		@RequestMapping(value = "/GradeInfo/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteGradeInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

		
}