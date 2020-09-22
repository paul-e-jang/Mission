package com.sjwp.mission.domain.model.article;

import java.util.List;

public interface ArticleService {

    Article store(Article article);

    void delete(Long articleId);

    Article findById(Long articleId);

    List<Article> findAll();
}
