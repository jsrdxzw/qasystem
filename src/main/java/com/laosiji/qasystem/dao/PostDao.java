package com.laosiji.qasystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laosiji.qasystem.domain.ro.PostFilterRo;
import com.laosiji.qasystem.entity.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Mapper
@Repository
public interface PostDao extends BaseMapper<Post> {

    /**
     * 帖子
     *
     * @param postNo 帖子编号
     * @return 帖子
     */
    Post getByPostNo(@Param("postNo") String postNo);


    /**
     * 列表
     *
     * @param postFilterRo postFilterRo
     * @return list
     */
    List<Post> getPostList(@Param("postFilterRo") PostFilterRo postFilterRo);
}
