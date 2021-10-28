package com.laosiji.qasystem.service;

import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.entity.model.Post;

import java.util.List;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
public interface PostService {

    /**
     * 详情
     *
     * @param postNo postNo
     * @return Post
     */
    com.laosiji.qasystem.entity.model.Post getPost(String postNo);

    /**
     * 发帖
     *
     * @param postRo postRo
     */
    void create(PostRo postRo);

    /**
     * 修改帖
     *
     * @param postRo postRo
     */
    void update(PostRo postRo);


    /**
     * 帖子列表
     *
     * @return list
     */
    List<Post> list();
}
