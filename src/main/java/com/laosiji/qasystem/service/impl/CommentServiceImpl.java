package com.laosiji.qasystem.service.impl;

import com.laosiji.qasystem.dao.CommentDao;
import com.laosiji.qasystem.domain.ro.CommentRo;
import com.laosiji.qasystem.entity.model.Comment;
import com.laosiji.qasystem.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public void createComment(CommentRo commentRo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentRo, comment);
        commentDao.insert(comment);
    }
}
