package com.laosiji.qasystem.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangxingming
 * @date 2021/10/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVo {
    private Integer code;
    private String message;
}
