package com.laosiji.qasystem.service.impl;

import com.laosiji.qasystem.dao.CommentDao;
import com.laosiji.qasystem.dao.PostDao;
import com.laosiji.qasystem.domain.enums.PCCategory;
import com.laosiji.qasystem.domain.ro.PostFilterRo;
import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.domain.vo.CommentVo;
import com.laosiji.qasystem.domain.vo.FilterVo;
import com.laosiji.qasystem.domain.vo.GetCategoryVo;
import com.laosiji.qasystem.domain.vo.PostVo;
import com.laosiji.qasystem.entity.model.Comment;
import com.laosiji.qasystem.entity.model.Post;
import com.laosiji.qasystem.service.PostService;
import com.laosiji.qasystem.util.CommonUtils;
import com.laosiji.qasystem.util.HttpUtils;
import com.laosiji.qasystem.util.PostUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
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

    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private CommonUtils commonUtils;


    @Override
    public PostVo getPost(String postNo) {
        Post post = postDao.getByPostNo(postNo);
        if (post == null) {
            return null;
        }
        PostVo postVo = new PostVo();
        BeanUtils.copyProperties(post, postVo);
        // 填充评论
        List<Comment> comments = commentDao.getCommentByPostId(post.getId());
        if (!CollectionUtils.isEmpty(comments)) {
            List<CommentVo> commentVos = comments.stream()
                    .sorted(Comparator.comparing(Comment::getLikesCount).reversed())
                    .map(comment -> {
                        CommentVo commentVo = new CommentVo();
                        BeanUtils.copyProperties(comment, commentVo);
                        // 填充二级评论
                        List<Comment> secondComments = commentDao.getCommentByCommentId(comment.getId());
                        if (!CollectionUtils.isEmpty(secondComments)) {
                            List<CommentVo> commentVos1 = secondComments.stream().map(comment1 -> {
                                CommentVo commentVo1 = new CommentVo();
                                BeanUtils.copyProperties(comment1, commentVo1);
                                return commentVo1;
                            }).collect(Collectors.toList());
                            commentVo.setCommentList(commentVos1);
                        }
                        return commentVo;
                    }).collect(Collectors.toList());
            postVo.setComments(commentVos);
        }
        return postVo;
    }

    @Override
    public void createPost(PostRo postRo) {
        Post post = new com.laosiji.qasystem.entity.model.Post();
        BeanUtils.copyProperties(postRo, post);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setPostNo(PostUtil.generateZhContractNo());
        //获取过滤后的内容
        String contentAfterFilter = commonUtils.getContentAfterFilter(postRo.getContent());
        post.setContent(contentAfterFilter);
        String postTitle = commonUtils.getContentAfterFilter(postRo.getPostTitle());
        post.setPostTitle(postTitle);
        //获取标签
        String category = commonUtils.getCategory(postRo);
        post.setTag(category);
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
