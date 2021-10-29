package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.CommentRo;
import com.laosiji.qasystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@RequestMapping("/comment")
@RestController
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/create")
    public ResultData<?> createComment(@Validated @RequestBody CommentRo commentRo) {
        commentService.createComment(commentRo);
        return ResultData.SUCCESS;
    }
}
