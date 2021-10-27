package com.laosiji.qasystem.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;


/**
 * @author xuzhiwei
 * @date 2021/10/19 7:16 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("employee")
public class Employee extends BaseModel {
    private String userName;

    private String passWord;

    private String email;

    private String avatar;


}
