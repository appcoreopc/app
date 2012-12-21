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

import com.appCore.personnel.Core.Job.Entity.Level;

import com.appCore.personnel.Core.Job.Service.LevelService;


@Controller
@RequestMapping("/Job")
public class LevelController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="levelService")
		private LevelService service;

		@RequestMapping(value = "/Level/list", method = RequestMethod.GET)		
		public @ResponseBody List<Level> listLevel () 
		{
				List<Level> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Level/get", method = RequestMethod.GET)		
		public @ResponseBody Level getLevel (@RequestParam(value="id", required=true) Integer id ) 
		{
				Level level=service.get(id);
				return level;
		}

		@RequestMapping(value = "/Level/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddLevel (@RequestBody Level level)
		{
				service.add(level);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Level/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addLevel (@RequestBody Level level)
		{
				service.add(level);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Level/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateLevel (@RequestBody Level level)
		{
				service.saveOrUpdate(level);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Level/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteLevel (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}