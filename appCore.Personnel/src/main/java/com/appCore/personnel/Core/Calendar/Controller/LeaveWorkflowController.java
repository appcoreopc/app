package com.appCore.personnel.Core.Calendar.Controller;

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
import com.appCore.personnel.Core.Calendar.Entity.LeaveWorkflow;
import com.appCore.personnel.Core.Calendar.Service.LeaveWorkflowService;

@Controller
@RequestMapping("/Calendar")
public class LeaveWorkflowController
{ 
	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="leaveWorkflowService")
		private LeaveWorkflowService service;

		@RequestMapping(value = "/LeaveWorkflow/list", method = RequestMethod.GET)		
		public @ResponseBody List<LeaveWorkflow> listLeaveWorkflow () 
		{
				List<LeaveWorkflow> list = service.getAll();
				return list;
		}
		
		@RequestMapping(value = "/LeaveWorkflow/listByCompany", method = RequestMethod.GET)		
		public @ResponseBody List<LeaveWorkflow> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
		{
				List<LeaveWorkflow> list = service.getAllByCompany(id);
				return list;
		}

		@RequestMapping(value = "/LeaveWorkflow/get", method = RequestMethod.GET)		
		public @ResponseBody LeaveWorkflow getLeaveWorkflow (@RequestParam(value="id", required=true) Integer id ) 
		{
				LeaveWorkflow leaveWorkflow=service.get(id);
				return leaveWorkflow;
		}

		@RequestMapping(value = "/LeaveWorkflow/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddLeaveWorkflow (@RequestBody LeaveWorkflow leaveWorkflow)
		{
				service.add(leaveWorkflow);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/LeaveWorkflow/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addLeaveWorkflow (@RequestBody LeaveWorkflow leaveWorkflow)
		{
				service.add(leaveWorkflow);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/LeaveWorkflow/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateLeaveWorkflow (@RequestBody LeaveWorkflow leaveWorkflow)
		{
				service.saveOrUpdate(leaveWorkflow);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/LeaveWorkflow/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteLeaveWorkflow (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}
}