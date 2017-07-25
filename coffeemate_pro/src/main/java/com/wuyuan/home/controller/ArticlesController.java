package com.wuyuan.home.controller;

import com.happylifeplat.Result;
import com.happylifeplat.messagecode.impl.AppApiCode;
import com.happylifeplat.messagecode.impl.CommonCode;
import com.happylifeplat.plugin.mybatis.pager.PageParameter;
import com.wuyuan.home.mapper.ArticlesMapper;
import com.wuyuan.home.module.ArticleDto;
import com.wuyuan.home.module.GeneralRequestDto;
import com.wuyuan.util.ServerSetting;
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

    @Autowired
    private ServerSetting serverSetting;

    @PostMapping("/insertArticles")
    @ResponseBody
    public Result insertArticles(@RequestBody ArticleDto atricle) {

        atricle.setId(UUID.randomUUID().toString());
        int result = articlesMapper.insertArticle(atricle);

        return Result.success(result);
    }

    @GetMapping("/list")
    @ResponseBody
    public Result getArticlesList(@RequestParam int page, String orderBy) {
        log.info("============================ArticlesController @ getArticlesList start=========\n");
        if(page == 0) {
            page = 1;
        }

        if(StringUtils.isEmpty(orderBy)) {
            orderBy = "-createtime";
        }

        GeneralRequestDto requestDto = new GeneralRequestDto();
        PageParameter pageParameter = new PageParameter();
        pageParameter.setCurrentPage(page);
        requestDto.setPage(pageParameter);

        if(!StringUtils.isEmpty(orderBy)) {
            requestDto.setOrderBy(orderBy);
        }

        List<ArticleDto> articles = articlesMapper.getArticlesPage(requestDto);
        articles.forEach(article -> article.setImage(serverSetting.getImagePrefix() + article.getImage()));
        log.info("============================ArticlesController @ getArticlesList end=========\n");
        return Result.success(articles);
    }

    @GetMapping("/getArticleById")
    @ResponseBody
    public Result getArticle(@RequestParam String articleId) {
        log.info("============================ArticlesController @ getArticleById start=========\n");
        if(StringUtils.isEmpty(articleId)) {
            return Result.error(AppApiCode.params_error);
        }

        ArticleDto article = articlesMapper.getArticleById(articleId);
        if(article == null) {
            return Result.error(CommonCode.fail);
        }

        article.setImage(serverSetting.getImagePrefix() + article.getImage());
        log.info("============================ArticlesController @ getArticleById end=========\n");
        return Result.success(article);
    }
}
