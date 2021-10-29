package com.laosiji.qasystem.entity.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "lyt_posts")
public class Post {

    private Long id;

    private String postNo;

    private Long authorId;

    private String authorName;

    private String postTitle;

    private String content;

    private String tag;

    private String weight;

    private Integer likesCount;

    private String subTitle;

    private String keyWords;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
