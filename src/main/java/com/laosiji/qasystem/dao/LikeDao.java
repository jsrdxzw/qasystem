package com.laosiji.qasystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laosiji.qasystem.entity.model.Like;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Repository
@Mapper
public interface LikeDao extends BaseMapper<Like> {

}
