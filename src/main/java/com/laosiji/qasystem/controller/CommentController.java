package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.CommentRo;
import com.laosiji.qasystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@RequestMapping("/comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/create")
    public ResultData<?> createComment(@Validated @RequestBody CommentRo commentRo) {
        commentService.createComment(commentRo);
        return ResultData.SUCCESS;
    }
}
