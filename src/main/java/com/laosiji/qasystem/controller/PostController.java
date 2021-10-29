package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.CommentRo;
import com.laosiji.qasystem.domain.ro.PostFilterRo;
import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.domain.vo.PostVo;
import com.laosiji.qasystem.entity.model.Post;
import com.laosiji.qasystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 发帖，点赞，评论
 *
 * @author zhangyixiao
 * @date 2021/10/27
 */
@RequestMapping("/post")
@RestController
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/ping")
    public ResultData<?> healthCheck() {
        return ResultData.SUCCESS;
    }

    @PostMapping("/create")
    public ResultData<?> createPost(@Validated @RequestBody PostRo postRo) {
        postService.createPost(postRo);
        return ResultData.SUCCESS;
    }

    @GetMapping("/{postNo}")
    public ResultData<PostVo> getPost(@PathVariable String postNo) {
        return ResultData.<PostVo>success()
                .data(postService.getPost(postNo))
                .build();
    }

    @GetMapping("/list")
    public ResultData<List<PostVo>> listPost(@RequestParam(required = false) String tag,
                                             @RequestParam(required = false) Long authorId) {
        return ResultData.<List<PostVo>>success()
                .data(
                        postService.listPost(PostFilterRo.builder()
                                .tag(tag)
                                .authorId(authorId)
                                .build()))
                .build();
    }
}
