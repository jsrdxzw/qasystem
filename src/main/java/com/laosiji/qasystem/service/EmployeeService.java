package com.laosiji.qasystem.service;

import com.laosiji.qasystem.dao.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }
}
