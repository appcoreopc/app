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
import com.appCore.personnel.Core.Entity.BranchInfo;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.BranchInfoService;


@Controller
@RequestMapping("/Core")
public class BranchInfoController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="branchInfoService")
		private BranchInfoService service;

		@RequestMapping(value = "/BranchInfo/list", method = RequestMethod.GET)		
		public @ResponseBody List<BranchInfo> listBranchInfo ( Model model ) 
		{
				List<BranchInfo> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/BranchInfo/listByRefEntity", method = RequestMethod.GET)		
		public @ResponseBody List<BranchInfo> listBranchInfo (@RequestParam(value="id", required=true) Integer id) 
		{
				List<BranchInfo> list = service.getAllByRefEntity(id);
				return list;
		}

		@RequestMapping(value = "/BranchInfo/get", method = RequestMethod.GET)		
		public @ResponseBody BranchInfo getBranchInfo (@RequestParam(value="id", required=true) Integer id, Model model ) 
		{
				BranchInfo branchInfo=service.get(id);
				model.addAttribute("modelData", branchInfo);
				return branchInfo;
		}

		@RequestMapping(value = "/BranchInfo/add", method = RequestMethod.GET)
		public String renderAddBranchInfo ( Model model ) 
		{
				model.addAttribute("modelData", new BranchInfo());
				return "View/Core/BranchInfo/add";
		}

		@RequestMapping(value = "/BranchInfo/add", method = RequestMethod.POST)
		public @ResponseBody String addBranchInfo (@ModelAttribute BranchInfo branchInfo)
		{
				service.add(branchInfo);
				return "View/Core/BranchInfo/add";
		}

		@RequestMapping(value = "/BranchInfo/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus  saveOrUpdateBranchInfo (@RequestBody BranchInfo branchInfo)
		{
				service.saveOrUpdate(branchInfo);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/BranchInfo/delete", method = RequestMethod.GET)
		public  @ResponseBody RequestStatus  deleteBranchInfo (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}

}