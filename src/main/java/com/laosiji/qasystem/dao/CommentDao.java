package com.laosiji.qasystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laosiji.qasystem.entity.model.Comment;
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
public interface CommentDao extends BaseMapper<Comment> {

    /**
     * @param postId
     * @return
     */
    List<Comment> getCommentByPostId(@Param("postId") Long postId);

}
