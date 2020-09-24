package com.sjwp.mission.domain.model.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	
	@Autowired
	ArticleRepository repo;

    public Article save(Article article) {
    	return repo.save(article);
    }
    
    public List<Article> saveAll(List<Article> articles) {
    	return repo.saveAll(articles);
    }

    public void deletebyId(Long articleId) {
    	repo.deleteById(articleId);
    }

    public List<Article> findAll(){
    	return (List<Article>) repo.findAll();
    }
}
