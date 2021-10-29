package com.laosiji.qasystem.domain.vo;

import com.laosiji.qasystem.domain.enums.PCCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhangyixiao
 * @date 2021/10/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {

    private Long id;

    private Long postId;

    private Long commentId;

    private Long authorId;

    private String authorName;

    private String comment;

    private Integer weight;

    private Integer likesCount;

    private PCCategory commentCategory;

    private List<CommentVo> commentList;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
