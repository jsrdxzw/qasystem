package com.laosiji.qasystem.service;

import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.EmployeeRo;
import com.laosiji.qasystem.domain.vo.EmployeeVo;
import com.laosiji.qasystem.entity.model.Employee;
import org.springframework.stereotype.Service;

/**
 * @author xuzhiwei
 * @date 2021/10/21 1:27 下午
 */
@Service
public interface EmployeeService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    EmployeeVo selectUserById(Integer id);

    /**
     * 注册
     * @param employeeRo
     * @return
     */
    ResultData register(EmployeeRo employeeRo);

    /**
     * 登陆
     * @param employeeRo
     * @return
     */
    ResultData login(EmployeeRo employeeRo);
}
