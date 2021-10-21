package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.entity.model.Employee;
import com.laosiji.qasystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author xuzhiwei
 * @date 2021/10/19 6:52 下午
 */
@RequestMapping("/employee")
@RestController
public class QASystemController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getByName")
    public Mono<Employee> getEmployeeByName(@RequestParam("name") String name) {
        return Mono.just(employeeService.getEmployeeByName(name));
    }
}
