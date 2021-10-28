package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 发帖，点赞，评论
 *
 * @author zhangyixiao
 * @date 2021/10/27
 */
@RequestMapping("/post")
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/ping")
    public ResultData<?> healthCheck() {
        return ResultData.SUCCESS;
    }

    @PostMapping("/create")
    public ResultData<?> create(@Validated @RequestBody PostRo postRo) {
        postService.create(postRo);
        return ResultData.SUCCESS;
    }




}
