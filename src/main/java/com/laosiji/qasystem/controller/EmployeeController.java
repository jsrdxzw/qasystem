package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.EmployeeRo;
import com.laosiji.qasystem.domain.vo.EmployeeVo;
import com.laosiji.qasystem.entity.model.Employee;
import com.laosiji.qasystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangxingming
 * @date 2021/10/28
 */
@RequestMapping("/employee")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/{id}")
    public ResultData<?> selectUserById(@PathVariable Integer id) {
        return ResultData.<EmployeeVo>success()
                .data(employeeService.selectUserById(id))
                .build();
    }

    @PostMapping("/register")
    public ResultData<?> register(@RequestBody EmployeeRo employeeRo){

        return employeeService.register(employeeRo);
    }
}
