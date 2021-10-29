package com.laosiji.qasystem.service.impl;

import com.laosiji.qasystem.dao.LikeDao;
import com.laosiji.qasystem.domain.ro.LikeRo;
import com.laosiji.qasystem.entity.model.Like;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void like(LikeRo likeRo) {
        Like like = new Like();
        BeanUtils.copyProperties(likeRo, like);
        likeDao.insert(like);

    }
}
