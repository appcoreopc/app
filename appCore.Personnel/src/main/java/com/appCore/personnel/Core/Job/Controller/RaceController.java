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

import com.appCore.Requests.CodeRequest;
import com.appCore.Requests.RequestStatus;
import com.appCore.personnel.Core.CodeChecker.CodeCheckerHelper;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Job.Entity.Race;

import com.appCore.personnel.Core.Job.Service.RaceService;


@Controller
@RequestMapping("/Job")
public class RaceController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="raceService")
		private RaceService service;
		
		@Resource(name="codeCheckerService")
		private CodeCheckerHelper codeService;
		
		@RequestMapping(value = "/Race/list", method = RequestMethod.GET)		
		public @ResponseBody List<Race> listRace () 
		{
				List<Race> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/Race/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<Race> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<Race> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/Race/get", method = RequestMethod.GET)		
		public @ResponseBody Race getRace (@RequestParam(value="id", required=true) Integer id ) 
		{
				Race race=service.get(id);
				return race;
		}
		
		@RequestMapping(value = "/Race/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddRace (@RequestBody Race race)
		{
				service.add(race);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Race/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addRace (@RequestBody Race race)
		{
				service.add(race);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Race/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateRace (@RequestBody Race race)
		{
				service.saveOrUpdate(race);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Race/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteRace (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}