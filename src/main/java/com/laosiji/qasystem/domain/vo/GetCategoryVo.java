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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryVo extends BaseVo {
    private CategoryDataVo data;
}
