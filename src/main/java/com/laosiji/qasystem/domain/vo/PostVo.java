package com.laosiji.qasystem.domain.vo;

import com.laosiji.qasystem.entity.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostVo {

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

    private List<CommentVo> comments;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
