package com.wuyuan.home.controller;

import com.happylifeplat.Result;
import com.happylifeplat.messagecode.impl.AppApiCode;
import com.happylifeplat.messagecode.impl.CommonCode;
import com.happylifeplat.plugin.mybatis.pager.PageParameter;
import com.wuyuan.home.mapper.ArticlesMapper;
import com.wuyuan.home.module.ArticleDto;
import com.wuyuan.home.module.GeneralRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by xuwuyuan on 2017/7/22.
 */
@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private static final Logger log = LoggerFactory.getLogger(ArticlesController.class);

    @Autowired
    private ArticlesMapper articlesMapper;

    @PostMapping("/insertArticles")
    @ResponseBody
    public Result insertArticles(@RequestBody ArticleDto atricle) {

        atricle.setId(UUID.randomUUID().toString());
        int result = articlesMapper.insertArticle(atricle);

        return Result.success(result);
    }

    @GetMapping("/list")
    @ResponseBody
    public Result getArticlesList(@RequestParam int page,
                                  @RequestParam String orderBy) {
        if(page == 0) {
            page = 1;
        }

        GeneralRequestDto requestDto = new GeneralRequestDto();
        PageParameter pageParameter = new PageParameter();
        pageParameter.setCurrentPage(page);
        requestDto.setPage(pageParameter);

        if(!StringUtils.isEmpty(orderBy)) {
            requestDto.setOrderBy(orderBy);
        }

        List<ArticleDto> articles = articlesMapper.getArticlesPage(requestDto);

        return Result.success(articles);
    }

    @GetMapping("/getArticleById")
    @ResponseBody
    public Result getArticle(@RequestParam String articleId) {
        if(StringUtils.isEmpty(articleId)) {
            return Result.error(AppApiCode.params_error);
        }

        ArticleDto article = articlesMapper.getArticleById(articleId);
        if(article == null) {
            return Result.error(CommonCode.fail);
        }

        return Result.success(article);
    }
}
