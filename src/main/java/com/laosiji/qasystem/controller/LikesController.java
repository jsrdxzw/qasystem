package com.laosiji.qasystem.controller;

import com.laosiji.qasystem.domain.res.ResultData;
import com.laosiji.qasystem.domain.ro.LikeRo;
import com.laosiji.qasystem.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
@RequestMapping("/like")
@RestController
@CrossOrigin(origins = "*")
public class LikesController {

    @Autowired
    private LikeService likeService;

    @GetMapping()
    public ResultData<?> like(@RequestBody LikeRo likeRo) {
        likeService.like(likeRo);
        return ResultData.SUCCESS;
    }
}
