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
import com.appCore.personnel.Core.Entity.BranchSummary;
import com.appCore.personnel.Core.Entity.Department;
import com.appCore.personnel.Core.Entity.Division;
import com.appCore.personnel.Core.Entity.DivisionSummary;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.DivisionService;


@Controller
@RequestMapping("/Core")
public class DivisionController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="divisionService")
		private DivisionService service;

		@RequestMapping(value = "/Division/getSummary", method = RequestMethod.GET)		
		public @ResponseBody DivisionSummary getSummary (@RequestParam(value="id", required=true) Integer id) 
		{
			return service.getSummary(id);
		}
		
		@RequestMapping(value = "/Division/list", method = RequestMethod.GET)		
		public @ResponseBody List<Division> listDivision ( Model model ) 
		{
				List<Division> list = service.getAll();
				model.addAttribute("data", list);
				return list;
		}
		
		@RequestMapping(value = "/Division/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Division> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<Division> list = service.getAllByCompany(id);
				return list;
		}
		
		
		@RequestMapping(value = "/Division/get", method = RequestMethod.GET)		
		public @ResponseBody Division getDivision (@RequestParam(value="id", required=true) Integer id) 
		{
				Division division=service.get(id);
				return division;
		}

		
		@RequestMapping(value = "/Division/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addDivision (@RequestBody Division division)
		{
				service.add(division);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Division/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateDivision (@RequestBody Division division)
		{
				service.saveOrUpdate(division);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Division/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteDivision (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
		
}