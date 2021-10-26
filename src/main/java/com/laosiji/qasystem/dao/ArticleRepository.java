package com.laosiji.qasystem.dao;

import com.laosiji.qasystem.entity.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xuzhiwei
 * @date 2021/10/26 3:06 下午
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
