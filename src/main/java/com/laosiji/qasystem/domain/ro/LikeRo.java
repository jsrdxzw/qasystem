package com.laosiji.qasystem.domain.ro;


import com.laosiji.qasystem.domain.enums.LikeType;
import com.laosiji.qasystem.domain.enums.PCCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhangyixiao
 * @date 2021/10/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeRo {

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
