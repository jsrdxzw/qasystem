package com.laosiji.qasystem.service;

import com.laosiji.qasystem.domain.ro.PostFilterRo;
import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.domain.vo.PostVo;
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
    PostVo getPost(String postNo);

    /**
     * 发帖
     *
     * @param postRo postRo
     */
    void createPost(PostRo postRo);

    /**
     * 修改帖
     *
     * @param postRo postRo
     */
    void updatePost(PostRo postRo);


    /**
     * 帖子列表
     *
     * @param postFilterRo postFilterRo
     * @return list
     */
    List<PostVo> listPost(PostFilterRo postFilterRo);
}
