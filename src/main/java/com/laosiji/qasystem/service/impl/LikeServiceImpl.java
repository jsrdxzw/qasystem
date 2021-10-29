package com.laosiji.qasystem.service.impl;

import com.laosiji.qasystem.dao.CommentDao;
import com.laosiji.qasystem.dao.LikeDao;
import com.laosiji.qasystem.dao.PostDao;
import com.laosiji.qasystem.domain.enums.PCCategory;
import com.laosiji.qasystem.domain.ro.LikeRo;
import com.laosiji.qasystem.entity.model.Comment;
import com.laosiji.qasystem.entity.model.Like;
import com.laosiji.qasystem.entity.model.Post;
import com.laosiji.qasystem.service.LikeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PostDao postDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void like(LikeRo likeRo) {
        Like like = new Like();
        BeanUtils.copyProperties(likeRo, like);
        likeDao.insert(like);
        if (PCCategory.COMMENT.equals(like.getLikeCategory())) {
            // 给评论点赞，更新评论赞数
            Comment comment = commentDao.selectById(like.getCommentId());
            if (comment == null) {
                return;
            }
            comment.setLikesCount(comment.getLikesCount() + 1);
            commentDao.updateById(comment);
            // 更新帖子赞树
            Post post = postDao.selectById(like.getPostId());
            if (post == null) {
                return;
            }
            post.setLikesCount(post.getLikesCount() + 1);
            postDao.updateById(post);
        }
    }
}
