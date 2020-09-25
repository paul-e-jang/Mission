package com.sjwp.mission.apis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;

@Controller
public class FileUploadApiController {
	
	@PostMapping(value="api/fileUpload")
    public ResponseEntity<ApiResult> Upload(MultipartHttpServletRequest request, @RequestParam MultipartFile image) throws IOException {
        
        File file = new File("classpath:/webapp/static/" + image.getOriginalFilename());
        image.transferTo(file);
        
        return Result.created();
    }


}