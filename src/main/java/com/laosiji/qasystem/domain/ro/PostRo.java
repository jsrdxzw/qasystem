package com.laosiji.qasystem.domain.ro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyixiao
 * @date 2021/10/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRo {

    private Long authorId;

    private String authorName;

    private String postTitle;

    private String content;

    private String tag;

    private Integer weight;

}
