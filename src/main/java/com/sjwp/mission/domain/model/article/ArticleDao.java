package com.sjwp.mission.domain.model.article;

import java.util.List;

public interface ArticleDao {

    Article store(Article course);

    void delete(Long courseId);

    Article findById(Long courseId);

    List<Article> findAll();
}
