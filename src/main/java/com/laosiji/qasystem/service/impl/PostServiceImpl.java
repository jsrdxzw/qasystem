package com.laosiji.qasystem.service.impl;

import com.laosiji.qasystem.dao.PostDao;
import com.laosiji.qasystem.domain.ro.PostFilterRo;
import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.entity.model.Post;
import com.laosiji.qasystem.service.PostService;
import com.laosiji.qasystem.util.PostUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public Post getPost(String postNo) {
        return postDao.getByPostNo(postNo);
    }

    @Override
    public void createPost(PostRo postRo) {
        Post post = new com.laosiji.qasystem.entity.model.Post();
        BeanUtils.copyProperties(postRo, post);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setPostNo(PostUtil.generateZhContractNo());

        postDao.insert(post);
    }

    @Override
    public void updatePost(PostRo postRo) {

    }

    @Override
    public List<Post> listPost(PostFilterRo postFilterRo) {
        return postDao.getPostList(postFilterRo);
    }
}
