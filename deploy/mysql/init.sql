CREATE DATABASE IF NOT EXISTS laoyoutiao;
use laoyoutiao;
CREATE TABLE `employee`
(
    `id`         int UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) NOT NULL,
    `password`   varchar(255) NULL,
    `email`      varchar(255) NULL,
    `avatar`     varchar(255) NULL,
    `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted_at` datetime     NOT NULL DEFAULT '1970-01-01 00:00:00' comment '删除时间',
    PRIMARY KEY (`id`)
);

INSERT INTO `employee` (name, password, email, avatar)
VALUES ('yyds', '123456', 'yyds@163.com',
        'https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00545-198.jpg');

CREATE TABLE `article`
(
    `id`          int UNSIGNED NOT NULL AUTO_INCREMENT,
    `title`       varchar(255) NOT NULL,
    `content`     text         NOT NULL,
    `employee_id` int          NULL     DEFAULT NULL COMMENT '发表人id',
    `created_at`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted_at`  datetime     NOT NULL DEFAULT '1970-01-01 00:00:00' comment '删除时间',
    PRIMARY KEY (`id`)
)
