package com.sjwp.mission.apis;

import java.io.File;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;
import com.sjwp.mission.application.FileService;


@Controller
public class FileUploadController {
	
	public FileUploadController(FileService service) {
		super();
	}
	
	@RequestMapping(value="/api/fileUpload")
    public ResponseEntity<ApiResult> fileUpload(@RequestParam("image") MultipartFile file, MultipartHttpServletRequest request) {
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/static/";
		String filename = file.getOriginalFilename();
		
		File f = new File("/"+filename);
		try {
		   file.transferTo(f);
			   
			  } catch (Exception e) {
				  e.printStackTrace();
			  }
		return Result.ok();
	}
}
