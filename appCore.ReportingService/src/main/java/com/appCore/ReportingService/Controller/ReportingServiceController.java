package com.appCore.reportingService.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.appCore.Requests.RequestStatus;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.reportingService.Entity.Report;
import com.appCore.reportingService.Entity.ReportRequest;
import com.appCore.reportingService.Service.ReportService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/reportingService")
public class ReportingServiceController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name = "reportService")
	private ReportService service;
			
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	
	@RequestMapping(value = "/Report/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Report> listReport() {
		List<Report> list = service.getAll();
		return list;
	}

	@RequestMapping(value = "/Report/listByCompany", method = RequestMethod.GET)
	public @ResponseBody
	List<Report> listByCompany(
			@RequestParam(value = "id", required = true) Integer id) {
		List<Report> list = service.getAllByCompany(id);
		return list;
	}

	@RequestMapping(value = "/Report/get", method = RequestMethod.GET)
	public @ResponseBody
	Report getReport(@RequestParam(value = "id", required = true) Integer id) {
		Report report = service.get(id);
		return report;
	}

	@RequestMapping(value = "/Report/add", method = RequestMethod.GET)
	public @ResponseBody
	RequestStatus renderAddReport(@RequestBody Report report) {
		service.add(report);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Report/add", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus addReport(@RequestBody Report report) {
		service.add(report);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Report/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus saveOrUpdateReport(@RequestBody Report report) {
		service.saveOrUpdate(report);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Report/delete", method = RequestMethod.GET)
	public @ResponseBody
	RequestStatus deleteReport(
			@RequestParam(value = "id", required = true) Integer id) {
		service.delete(id);
		return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
	}

	@RequestMapping(value = "/Report/getReport", method = RequestMethod.GET)
	public @ResponseBody
	String getReport(
			@RequestParam(value = "id", required = true) ReportRequest reportRequest) {
		return "";
	}

	@RequestMapping(value = "/Report/executeReport", method = RequestMethod.GET)
	//public @ResponseBody RequestStatus executeReport(@RequestParam ReportRequest reportRequest)
	public @ResponseBody RequestStatus executeReport(@RequestParam Integer id)
	
			throws IOException, InstantiationException, IllegalAccessException {

		System.out.println("entering into our service");
		
		ReportRequest reportRequest = new ReportRequest();
		service.executeReport(reportRequest);
		return RequestStatusHelper.GenerateRequestStatusCreateOperation();

	}

	@RequestMapping(value = "/Report/getReportStatus", method = RequestMethod.GET)
	public @ResponseBody
	String getReportStatus(
			@RequestParam(value = "id", required = true) Integer id) {
		return "";
	}

	// ///////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/Report/getAllUserReport", method = RequestMethod.GET)
	public @ResponseBody
	String getAllUserReport(
			@RequestParam(value = "id", required = true) Integer userId) {
		return "";
	}

	// Save and update
	// Also inclusive of saving of schedule report
	@RequestMapping(value = "/Report/saveUserReport", method = RequestMethod.GET)
	public @ResponseBody
	String saveUserReport(
			@RequestParam(value = "id", required = true) Integer id) {
		return "";
	}

	@RequestMapping(value = "/Report/deleteUserReport", method = RequestMethod.GET)
	public @ResponseBody
	String deleteUserReport(
			@RequestParam(value = "id", required = true) Integer id) {
		return "";
	}

	@RequestMapping(value = "/Report/getUserReport", method = RequestMethod.GET)
	public @ResponseBody
	String getUserReport(@RequestParam(value = "id", required = true) Integer id) {
		return "";
	}

}
