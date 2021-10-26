package com.laosiji.qasystem.dao;

import com.laosiji.qasystem.entity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xuzhiwei
 * @date 2021/10/21 1:18 下午
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
}
