package com.laosiji.qasystem.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangyixiao
 * @date 2021/10/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetKeyWords extends BaseVo {
    private List<KeyWords> data;
}
