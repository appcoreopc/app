package com.appCore.personnel.Core.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import groovy.util.ResourceException;
import groovy.util.ScriptException;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import org.codehaus.groovy.control.CompilationFailedException;


import com.appCore.Mvc.Controller.AppCoreController;
import com.appCore.Requests.RequestStatus;
import com.appCore.Scripting.GroovyScriptProvider;
import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Entity.BranchSummary;
import com.appCore.personnel.Core.Entity.UnitSummary;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.Core.Job.Entity.AssociationMembershipType;
import com.appCore.personnel.Core.Service.BranchService;
import com.appCore.reportingService.Core.RunnableReport;

@Controller
@RequestMapping("/Core")
public class BranchController {

	protected static Logger logger = Logger.getLogger("controller");
	@Resource(name = "branchService")
	private BranchService service;

	@RequestMapping(value = "/Branch/getSummary", method = RequestMethod.GET)
	public @ResponseBody
	BranchSummary getSummary(
			@RequestParam(value = "id", required = true) Integer id) {
		return service.getSummary(id);
	}

	@RequestMapping(value = "/Branch/listByCompany", method = RequestMethod.GET)
	public @ResponseBody
	List<Branch> listByCompany(
			@RequestParam(value = "id", required = true) Integer id) {
		List<Branch> list = service.getAllByCompany(id);
		return list;
	}

	@RequestMapping(value = "/Branch/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Branch> listBranch() {
		List<Branch> list = service.getAll();
		return list;
	}

	@RequestMapping(value = "/Branch/get", method = RequestMethod.GET)
	public @ResponseBody
	Branch getBranch(@RequestParam(value = "id", required = true) Integer id) {
		Branch branch = service.get(id);
		return branch;
	}
	
	
	@RequestMapping(value = "/Branch/getCompile", method = RequestMethod.GET)
	public @ResponseBody
	String getCompile(@RequestParam(value = "id", required = true) Integer id) throws IOException, ResourceException, ScriptException, CompilationFailedException, InstantiationException, IllegalAccessException {
		
		GroovyScriptProvider scripting = new GroovyScriptProvider("c:\\temp\\");
		RunnableReport rpt = scripting.createInstance("c:\\temp\\reportTest.groovy");
		
		int statusReport = rpt.getReportStatus();
		
		int executeStatus = rpt.executeReport();
		
		
		System.out.println("status report" + statusReport);
		System.out.println("execute status"+ executeStatus);
		//scripting.executeScript("hello.groovy");
		//scripting.invokeMethodOnClass("employee.groovy", "plus",  new Object[] {10 });
		return "test";
	}

	@RequestMapping(value = "/Branch/add", method = RequestMethod.GET)
	public @ResponseBody
	RequestStatus renderAddBranch(@RequestBody Branch branch) {
		service.add(branch);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Branch/add", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus addBranch(@RequestBody Branch branch) {
		service.add(branch);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Branch/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus saveOrUpdateBranch(@RequestBody Branch branch) {
		service.saveOrUpdate(branch);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Branch/delete", method = RequestMethod.GET)
	public @ResponseBody
	RequestStatus deleteBranch(
			@RequestParam(value = "id", required = true) Integer id) {
		service.delete(id);
		return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
	}
	
}