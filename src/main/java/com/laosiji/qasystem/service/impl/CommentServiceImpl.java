package com.laosiji.qasystem.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import com.laosiji.qasystem.dao.CommentDao;
import com.laosiji.qasystem.domain.ro.CommentRo;
import com.laosiji.qasystem.domain.ro.FilterRo;
import com.laosiji.qasystem.domain.vo.FilterVo;
import com.laosiji.qasystem.domain.vo.GetCategoryVo;
import com.laosiji.qasystem.entity.model.Comment;
import com.laosiji.qasystem.service.CommentService;
import com.laosiji.qasystem.util.CommonUtils;
import com.laosiji.qasystem.util.HttpUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommonUtils commonUtils;

    @Override
    public void createComment(CommentRo commentRo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentRo, comment);
        String contentAfterFilter = commonUtils.getContentAfterFilter(comment.getComment());
        comment.setComment(contentAfterFilter);
        commentDao.insert(comment);
    }


}
