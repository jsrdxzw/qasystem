package com.laosiji.qasystem.service.impl;

import com.laosiji.qasystem.dao.CommentDao;
import com.laosiji.qasystem.dao.PostDao;
import com.laosiji.qasystem.domain.ro.PostFilterRo;
import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.domain.vo.PostVo;
import com.laosiji.qasystem.entity.model.Comment;
import com.laosiji.qasystem.entity.model.Post;
import com.laosiji.qasystem.service.PostService;
import com.laosiji.qasystem.util.PostUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public PostVo getPost(String postNo) {
        Post post = postDao.getByPostNo(postNo);
        PostVo postVo = new PostVo();
        BeanUtils.copyProperties(post, postVo);
        // 填充评论
        postVo.setComments(commentDao.getCommentByPostId(post.getId()));
        return postVo;
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
    public List<PostVo> listPost(PostFilterRo postFilterRo) {
        List<Post> postList = postDao.getPostList(postFilterRo);
        return postList.stream().map(post -> {
            PostVo postVo = new PostVo();
            BeanUtils.copyProperties(post, postVo);
            return postVo;
        }).collect(Collectors.toList());
    }
}
