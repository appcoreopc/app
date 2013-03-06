package com.appCore.personnel.Core.Controller;
	
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.util.Streams;
import org.apache.log4j.Logger;

import com.appCore.personnel.Core.Helpers.CoreConstants;
import com.appCore.personnel.Core.Helpers.FileContentHelper;
import com.appCore.Mvc.Controller.AppCoreController;
import com.appCore.Requests.RequestStatus;
import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Entity.BranchSummary;
import com.appCore.personnel.Core.Entity.FileUploadContent;
import com.appCore.personnel.Core.Entity.UnitSummary;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.Core.Job.Entity.AssociationMembershipType;
import com.appCore.personnel.Core.Service.BranchService;

@Controller
@RequestMapping("/Core")
public class FileUploadController {

	protected static Logger logger = Logger.getLogger("controller");	
	
	@RequestMapping(value = "/create/upload", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json")
	@ResponseBody()
	public String handleImageUpload(MultipartFile file, @RequestParam(value = "fileName") String name) throws IOException, FileUploadException 
	{
		if (file.getSize() > 0 && !name.isEmpty()) {
			String contentType = file.getContentType();
			File targetFileName = new java.io.File(CoreConstants.fileUploadEmployeePixPath + name + FileContentHelper.getFileExtByContent(contentType));
			file.transferTo(targetFileName);
			return "{\"success\": true}";
		} else {
			return "{\"success\": false}";
		}
	}
		
}