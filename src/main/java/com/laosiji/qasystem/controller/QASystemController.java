package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzhiwei
 * @date 2021/10/19 6:52 下午
 */
@RequestMapping("/employee")
@RestController
@CrossOrigin(origins = "*")
public class QASystemController {
    @Autowired
    private EmployeeService employeeService;

}
