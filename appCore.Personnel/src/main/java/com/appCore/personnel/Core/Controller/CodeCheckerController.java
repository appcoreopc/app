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

import com.appCore.Requests.CodeRequest;
import com.appCore.Requests.RequestStatus;

import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Entity.BranchSummary;
import com.appCore.personnel.Core.Entity.UnitSummary;
import com.appCore.personnel.Core.Helpers.CodeCheckerHelper;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.Core.Job.Entity.AssociationMembershipType;
import com.appCore.personnel.Core.Service.BranchService;

@Controller
@RequestMapping("/Core")
public class CodeCheckerController {

	protected static Logger logger = Logger.getLogger("controller");
	@Resource(name="codeCheckerService")
	private CodeCheckerHelper service;

	@RequestMapping(value = "/CodeChecker/checkExist", method = RequestMethod.POST)		
	public @ResponseBody RequestStatus checkExist(@RequestBody CodeRequest codeRequest) 
	{			
		return service.checkExist(codeRequest);
	}
	
}