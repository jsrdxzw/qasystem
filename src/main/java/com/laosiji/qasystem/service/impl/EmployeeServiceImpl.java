package com.laosiji.qasystem.service.impl;

import com.laosiji.qasystem.dao.EmployeeDao;
import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.EmployeeRo;
import com.laosiji.qasystem.domain.vo.EmployeeVo;
import com.laosiji.qasystem.entity.model.Employee;
import com.laosiji.qasystem.service.EmployeeService;
import com.laosiji.qasystem.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * @author huangxingming
 * @date 2021/10/28
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;



    private final static Integer ERROR_CODE = -1;

    @Override
    public EmployeeVo selectUserById(Integer id) {
        Employee employee = employeeDao.selectById(id);
        EmployeeVo employeeVo = EmployeeVo.builder().build();
        if (employee != null) {
            employeeVo = EmployeeVo.builder()
                    .id(employee.getId())
                    .avatar(employee.getAvatar())
                    .email(employee.getEmail())
                    .passWord(employee.getPassWord())
                    .userName(employee.getUserName())
                    .createdAt(employee.getCreatedAt())
                    .deletedAt(employee.getDeletedAt())
                    .updatedAt(employee.getUpdatedAt())
                    .build();
        }
        return employeeVo;
    }

    @Override
    public ResultData register(EmployeeRo employeeRo) {
        ResultData resultData = ResultData.SUCCESS;
        String userName = employeeRo.getUserName();
        String passWord = employeeRo.getPassWord();
        String email = employeeRo.getEmail();
        if (!StringUtils.hasText(userName)) {
            resultData = ResultData.fail(ERROR_CODE, "用户名不能为空");
            return resultData;
        }
        if (!StringUtils.hasText(passWord)) {
            resultData = ResultData.fail(ERROR_CODE, "密码不能为空");
            return resultData;
        }
        if (!StringUtils.hasText(email)) {
            resultData = ResultData.fail(ERROR_CODE, "邮箱不能为空");
            return resultData;
        }
        //通过用户名查询
        Employee employee = employeeDao.selectUserByUserName(userName);
        if (employee != null) {
            resultData = ResultData.fail(ERROR_CODE, "该用户名已被其他人使用,请修改用户名");
            return resultData;
        }
        Employee employeeByEmail = employeeDao.selectUserByEmail(email);
        if (employeeByEmail != null) {
            resultData = ResultData.fail(ERROR_CODE, "该邮箱已被其他人使用,请修改邮箱");
            return resultData;
        }
        String avatar = randomAvatar();
        Employee data = Employee.builder()
                .email(employeeRo.getEmail())
                .passWord(employeeRo.getPassWord())
                .userName(employeeRo.getUserName())
                .avatar(avatar)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        employeeDao.insert(data);
        return resultData;
    }

    @Override
    public ResultData login(EmployeeRo employeeRo) {
        ResultData resultData = ResultData.SUCCESS;
        String userName = employeeRo.getUserName();
        String passWord = employeeRo.getPassWord();
        if (!StringUtils.hasText(userName)) {
            resultData = ResultData.fail(ERROR_CODE, "用户名不能为空");
            return resultData;
        }
        if (!StringUtils.hasText(passWord)) {
            resultData = ResultData.fail(ERROR_CODE, "密码不能为空");
            return resultData;
        }

        //先用账号查询
        Employee employee = employeeDao.selectUserByUserName(userName);
        if (employee == null) {
            resultData = ResultData.fail(ERROR_CODE, "该用户不存在");
            return resultData;
        } else {
            String dataPassWord = employee.getPassWord();
            if (!StringUtils.hasText(dataPassWord) || !passWord.equals(dataPassWord)) {
                resultData = ResultData.fail(ERROR_CODE, "该用户密码错误");
                return resultData;
            }
        }
        resultData.setData(employee);
        return resultData;
    }

    public String randomAvatar() {
        String avatar = "";
        String[] url = new String[]{"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F010f51555599c70000009c505e0339.jpg%401280w_1l_2o_100sh.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637997281&t=074c2c65bc24cdf0398dd2931e83fccc",
                "https://img1.baidu.com/it/u=2201785785,3682315029&fm=26&fmt=auto",
                "https://img2.baidu.com/it/u=4085106081,2082484180&fm=26&fmt=auto",
                "https://img2.baidu.com/it/u=781741493,2855287825&fm=26&fmt=auto",
                "https://img0.baidu.com/it/u=2042576536,887901109&fm=26&fmt=auto",
                "https://img0.baidu.com/it/u=1963060547,3824798154&fm=26&fmt=auto",
                "https://img0.baidu.com/it/u=1222914473,2533290639&fm=26&fmt=auto",
                "https://img2.baidu.com/it/u=1192270114,2642602379&fm=26&fmt=auto"};
        long timeMillis = System.currentTimeMillis();
        System.out.println(url.length);
        avatar = url[(int) (timeMillis % (url.length - 1))];
        return avatar;
    }
}
