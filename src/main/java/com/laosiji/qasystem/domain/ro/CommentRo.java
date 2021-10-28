package com.laosiji.qasystem.domain.ro;

import com.laosiji.qasystem.domain.enums.CommentCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author zhangyixiao
 * @date 2021/10/27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRo {

    @NotNull(message = "postId必传")
    private Long postId;

    private Long commentId;

    @NotNull(message = "作者id必传")
    private Long authorId;

    @NotNull(message = "作者必传")
    private String authorName;

    @NotNull(message = "comment必传")
    private String comment;

    @NotNull(message = "comment类型必传")
    private CommentCategory commentCategory;

}
