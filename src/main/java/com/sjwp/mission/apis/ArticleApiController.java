package com.sjwp.mission.apis;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    	return (List<Article>) service.findAll();
    }


}


