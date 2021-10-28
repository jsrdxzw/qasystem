package com.laosiji.qasystem.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangxingming
 * @date 2021/10/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterVo extends BaseVo {
    private String data;
}
