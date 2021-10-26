package com.laosiji.qasystem.entity.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author xuzhiwei
 * @date 2021/10/19 7:16 下午
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseModel {

    private String name;

    private String password;

    private String email;

    private String avatar;


}
