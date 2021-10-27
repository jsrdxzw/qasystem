package com.laosiji.qasystem.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;


/**
 * @author xuzhiwei
 * @date 2021/10/26 3:04 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class Article extends BaseModel {

    private String title;

    private String content;

    private Integer employeeId;
}
