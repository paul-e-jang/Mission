package com.sjwp.mission.apis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;


@Controller
public class FileUploadController {
	private final Path fileLocation;
	
	public FileUploadController() {
		super();
		this.fileLocation = Paths.get("./src/main/webapp/resources/static/").toAbsolutePath().normalize();
	}
	
	@RequestMapping(value="/api/upload", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResult> fileUpload(@RequestParam("upload") MultipartFile file, MultipartHttpServletRequest request, HttpSession session) {
	
	try {
		
	  File f = new File("classpath:/"+file.getOriginalFilename());
	  file.transferTo(f);
	  
	  /* local absolute path copy
	  Files.createDirectories(this.fileLocation);
	  
  	  String originalFileName = file.getOriginalFilename();
  	  Path targetLocation = this.fileLocation.resolve(originalFileName);
  	  Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
  	  
  	  */
	  
	  }catch (IllegalStateException e1) {
		e1.printStackTrace();
	  } catch (IOException e1) {
		e1.printStackTrace();
	  }
		return Result.ok();
		
    }
	
}
