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
		public @ResponseBody List<SectionInfo> listSectionInfo () 
		{
				List<SectionInfo> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/SectionInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<SectionInfo> listSectionInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<SectionInfo> list = service.getAllByRefEntity(id);
				return list;
		}

		@RequestMapping(value = "/SectionInfo/get", method = RequestMethod.GET)		
		public @ResponseBody SectionInfo getSectionInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				SectionInfo sectionInfo=service.get(id);
				return sectionInfo;
		}
		
		@RequestMapping(value = "/SectionInfo/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addSectionInfo (@RequestBody SectionInfo sectionInfo)
		{
				service.add(sectionInfo);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/SectionInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateSectionInfo (@RequestBody SectionInfo sectionInfo)
		{
				int saveId = service.saveOrUpdate(sectionInfo);
				RequestStatus status = RequestStatusHelper.GenerateRequestStatusSaveOperation();
				status.setSaveCode(saveId);
				
				return status; 
		}

		@RequestMapping(value = "/SectionInfo/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteSectionInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
		
}