package com.laosiji.qasystem.service;

import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.domain.vo.PostVo;

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
     * @return PostVo
     */
    PostVo getPost(String postNo);

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
    List<PostVo> list();
}
