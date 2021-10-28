package com.laosiji.qasystem.service;

import com.laosiji.qasystem.domain.ro.CommentRo;
import com.laosiji.qasystem.entity.model.Comment;
import com.laosiji.qasystem.entity.model.Post;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
public interface CommentService {

    /**
     * comment
     *
     * @param commentRo commentRo
     */
    void createComment(CommentRo commentRo);



}
