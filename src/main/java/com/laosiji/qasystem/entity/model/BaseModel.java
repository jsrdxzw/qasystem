package com.laosiji.qasystem.entity.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xuzhiwei
 * @date 2021/10/26 3:04 下午
 */
@Data
public class BaseModel {
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
