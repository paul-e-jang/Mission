package com.sjwp.mission.domain.model.member;

import org.springframework.data.repository.CrudRepository;

import com.sjwp.mission.domain.model.article.Article;

public interface MemberRepository extends CrudRepository<Article, Long> {
}
