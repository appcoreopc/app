package com.appCore.ReportingService.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;

import com.appCore.ReportingService.Entity.ReportRequest;

@Controller
@RequestMapping("/Core")
public class ReportingServiceController {

	protected static Logger logger = Logger.getLogger("controller");

	@RequestMapping(value = "/Report/getReport", method = RequestMethod.GET)
	public @ResponseBody
	String getReport(@RequestParam(value = "id", required = true) ReportRequest reportRequest) {
		return "";
	}

	@RequestMapping(value = "/Report/getReportStatus", method = RequestMethod.GET)
	public @ResponseBody
	String getReportStatus(
			@RequestParam(value = "id", required = true) Integer id) {
		return "";
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/Report/getAllUserReport", method = RequestMethod.GET)
	public @ResponseBody
	String getAllUserReport(
			@RequestParam(value = "id", required = true) Integer id) {
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

	/////////////////////////////////////////////////////////////////////////////////////////

}
