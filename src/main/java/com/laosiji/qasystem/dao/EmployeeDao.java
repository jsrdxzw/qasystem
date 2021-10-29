package com.laosiji.qasystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laosiji.qasystem.entity.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuzhiwei
 * @date 2021/10/21 1:18 下午
 */
@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    Employee selectUserByUserName(@Param("userName") String userName);

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @return
     */
    Employee selectUserByEmail(@Param("email") String email);




}
