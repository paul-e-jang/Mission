package com.sjwp.mission.apis;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjwp.mission.domain.model.article.Article;
import com.sjwp.mission.domain.model.article.ArticleLoadException;
import com.sjwp.mission.domain.model.article.ArticleRegistrationException;
import com.sjwp.mission.domain.model.article.ArticleService;



@Controller
public class ArticleApiController{
	
	ArticleService service;
	
	public ArticleApiController(ArticleService articleService) {
		super();
		this.service = articleService;
	}
	
    @RequestMapping(value="/api/{boardname}/articles")
    @ResponseBody
    public List<Article> getArticles(@PathVariable("boardname") String boardname)
    		throws ArticleLoadException {
    	return service.findAll();
    }


}


