package com.laosiji.qasystem.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.laosiji.qasystem.domain.enums.PCCategory;
import com.laosiji.qasystem.domain.enums.LikeType;
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
@TableName(value = "lyt_likes")
public class Like {

    private Long id;

    private Long postId;

    private Long commentId;

    private LikeType likeType;

    private PCCategory likeCategory;

    private Long authorId;

    private String authorName;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
