package com.laosiji.qasystem.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author huangxingming
 * @date 2021/10/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "lyt_employee")
public class Employee {

    private Long id;

    private String userName;

    private String passWord;

    private String email;

    private String avatar;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
