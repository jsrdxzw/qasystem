package com.laosiji.qasystem.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.laosiji.qasystem.domain.enums.CommentCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "lyt_comments")
public class Comment {

    private Long id;

    private Long postId;

    private Long commentId;

    private Long authorId;

    private String authorName;

    private String comment;

    private Integer weight;

    private Integer likesCount;

    private CommentCategory commentCategory;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
