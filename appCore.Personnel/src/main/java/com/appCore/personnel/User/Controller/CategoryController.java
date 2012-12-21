package com.appCore.personnel.User.Controller;

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

import com.appCore.personnel.User.Entity.Category;

import com.appCore.personnel.User.Service.CategoryService;


@Controller
@RequestMapping("/User")
public class CategoryController
{ 

	
		protected static Logger logger = Logger.getLogger("controller");
		@Resource(name="categoryService")
		private CategoryService service;

		@RequestMapping(value = "/Category/list", method = RequestMethod.GET)		
		public @ResponseBody List<Category> listCategory () 
		{
				List<Category> list = service.getAll();
				return list;
		}

		@RequestMapping(value = "/Category/get", method = RequestMethod.GET)		
		public @ResponseBody Category getCategory (@RequestParam(value="id", required=true) Integer id ) 
		{
				Category category=service.get(id);
				return category;
		}

		@RequestMapping(value = "/Category/add", method = RequestMethod.GET)
		public @ResponseBody RequestStatus renderAddCategory (@RequestBody Category category)
		{
				service.add(category);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Category/add", method = RequestMethod.POST)
		public @ResponseBody RequestStatus addCategory (@RequestBody Category category)
		{
				service.add(category);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Category/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody RequestStatus saveOrUpdateCategory (@RequestBody Category category)
		{
				service.saveOrUpdate(category);
				return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		}

		@RequestMapping(value = "/Category/delete", method = RequestMethod.GET)
		public @ResponseBody RequestStatus deleteCategory (@RequestParam(value="id", required=true) Integer id)
		{
				service.delete(id);
				return RequestStatusHelper.GenerateRequestStatusDeleteOperation();
		}


}