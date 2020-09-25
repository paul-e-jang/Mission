package com.sjwp.mission.apis;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.sjwp.mission.apis.payload.FileUploadPayload;
import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;
import com.sjwp.mission.domain.model.article.Article;
import com.sjwp.mission.domain.model.article.ArticleLoadException;
import com.sjwp.mission.domain.model.article.ArticleService;



@Controller
public class ArticleApiController{
	
	ArticleService service;
	
	public ArticleApiController(ArticleService articleService) {
		super();
		this.service = articleService;
	}
	
    @GetMapping(value="/api/getArticles")
    @ResponseBody
    public List<Article> getArticles()
    		throws ArticleLoadException {
    	return service.findAll();
    }
    
	@PostMapping(value="/api/registerArticle", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResult> articleRegister(@Valid @RequestBody FileUploadPayload payload) {
	  Article newArticle = Article.Create(payload.getImgName(), payload.getImgSize(), payload.getUploader(), payload.getUploaded_time());
	  service.save(newArticle);
	  	return Result.created();
	}

}


