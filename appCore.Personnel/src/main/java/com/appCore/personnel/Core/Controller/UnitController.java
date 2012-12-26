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
import com.appCore.personnel.Core.Entity.Section;
import com.appCore.personnel.Core.Entity.Unit;
import com.appCore.personnel.Core.Entity.UnitSummary;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;

import com.appCore.personnel.Core.Service.UnitService;

@Controller
@RequestMapping("/Core")
public class UnitController {

	protected static Logger logger = Logger.getLogger("controller");
	@Resource(name = "unitService")
	private UnitService service;

	@RequestMapping(value = "/Unit/getSummary", method = RequestMethod.GET)
	public @ResponseBody
	UnitSummary getSummary(
			@RequestParam(value = "id", required = true) Integer id) {
		return service.getSummary(id);
	}

	@RequestMapping(value = "/Unit/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Unit> listUnit() {
		List<Unit> list = service.getAll();
		return list;
	}

	
	@RequestMapping(value = "/Unit/listByCompany", method = RequestMethod.GET)		
	public @ResponseBody List<Unit> listByCompany (@RequestParam(value="id", required=true) Integer id ) 
	{
			List<Unit> list = service.getAllByCompany(id);
			return list;
	}
	
	@RequestMapping(value = "/Unit/get", method = RequestMethod.GET)
	public @ResponseBody
	Unit getUnit(@RequestParam(value = "id", required = true) Integer id) {
		Unit unit = service.get(id);
		return unit;
	}

	@RequestMapping(value = "/Unit/add", method = RequestMethod.GET)
	public String renderAddUnit(Model model) {
		model.addAttribute("modelData", new Unit());
		return "View/Core/Unit/add";
	}

	@RequestMapping(value = "/Unit/add", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus addUnit(@RequestBody Unit unit) {
		service.add(unit);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Unit/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus saveOrUpdateUnit(@RequestBody Unit unit) {
		service.saveOrUpdate(unit);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

	@RequestMapping(value = "/Unit/delete", method = RequestMethod.GET)
	public @ResponseBody
	RequestStatus deleteUnit(
			@RequestParam(value = "id", required = true) Integer id) {
		service.delete(id);
		return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
	}

	@RequestMapping(value = "/Unit/edit", method = RequestMethod.GET)
	public String editUnit(Model model) {
		return "View/Core/Unit/edit";
	}

}