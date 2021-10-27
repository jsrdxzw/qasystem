package com.laosiji.qasystem.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laosiji.qasystem.entity.model.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuzhiwei
 * @date 2021/10/26 3:06 下午
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {
}
