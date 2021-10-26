package com.laosiji.qasystem.entity.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author xuzhiwei
 * @date 2021/10/26 3:04 下午
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseModel {

    private String title;

    private String content;

    private Integer employeeId;
}
