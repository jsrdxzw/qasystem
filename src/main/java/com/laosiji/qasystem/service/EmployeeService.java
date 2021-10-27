package com.laosiji.qasystem.service;

import com.laosiji.qasystem.dao.EmployeeDao;
import com.laosiji.qasystem.entity.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuzhiwei
 * @date 2021/10/21 1:27 下午
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployeeByUserName(String userName) {
        return employeeDao.findByUserName(userName);
    }
}
