package com.wuyuan.home.controller;

import com.happylifeplat.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xuwuyuan on 2017/7/22.
 */
@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private static final Logger log = LoggerFactory.getLogger(ArticlesController.class);

    @GetMapping("/list")
    @ResponseBody
    public Result getArticlesList(@RequestParam int page) {
        if(page == 0) {
            page = 1;
        }

        return Result.success();
    }
}
