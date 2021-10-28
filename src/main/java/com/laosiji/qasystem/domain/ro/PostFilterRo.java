package com.laosiji.qasystem.domain.ro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFilterRo {

    private String tag;

    private Long authorId;

}
