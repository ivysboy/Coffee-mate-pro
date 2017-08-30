package com.wuyuan.home.controller;

import com.happylifeplat.Result;
import com.happylifeplat.messagecode.impl.AppApiCode;
import com.happylifeplat.messagecode.impl.CommonCode;
import com.happylifeplat.plugin.mybatis.pager.PageParameter;
import com.wuyuan.config.ApolloCoffeeMateConfig;
import com.wuyuan.home.mapper.ArticlesMapper;
import com.wuyuan.home.module.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
    private ApolloCoffeeMateConfig apolloCoffeeMateConfig;

    @PostMapping("/insertArticles")
    @ResponseBody
    public Result insertArticles(@RequestBody ArticleDto atricle) {

        atricle.setId(UUID.randomUUID().toString());
        int result = articlesMapper.insertArticle(atricle);

        return Result.success(result);
    }

    @PostMapping("/list")
    @ResponseBody
    public Result getArticlesList(@RequestBody GeneralRequestDto requestDto) {
        if(StringUtils.isEmpty(requestDto.getGroupId())
           && StringUtils.isEmpty(requestDto.getUserId())) {
            return Result.error(AppApiCode.params_error);
        }

        if(requestDto.getPage() == null) {
            requestDto.setPage(new PageParameter());
        }

        if(StringUtils.isEmpty(requestDto.getOrderBy())) {
            requestDto.setOrderBy("-createtime");
        }

        List<ArticleListDto> articles = articlesMapper.getArticlesPage(requestDto);
        articles.forEach(article -> article.setImage(apolloCoffeeMateConfig.getImagePrefix() + article.getImage()));
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

        article.setImage(apolloCoffeeMateConfig.getImagePrefix() + article.getImage());
        return Result.success(article);
    }

    @PostMapping("/collectArticle")
    @ResponseBody
    public Result collectArticles(@RequestBody CollectArticleDto collection) {
        if(StringUtils.isEmpty(collection.getArticleId())
                || StringUtils.isEmpty(collection.getUserId())){
            return Result.error(AppApiCode.params_error);
        }

        if(CollectionEnum.getCollection(collection.getOperation()) == null) {
            collection.setOperation(1);
        }

        CollectionEnum collectAction = CollectionEnum.getCollection(collection.getOperation());

        switch (collectAction) {
            case COLLECT: {
                List<String> existArticles = articlesMapper.checkCollectionExist(collection);
                if(!CollectionUtils.isEmpty(existArticles)) {
                    return Result.error();
                }

                collection.setId(UUID.randomUUID().toString());
                int result = articlesMapper.insertCollectArticle(collection);
                if(result <= 0) {
                    return Result.error();
                }

                return Result.success();
            }
            case DIS_COLLECT: {
                List<String> existArticles = articlesMapper.checkCollectionExist(collection);
                if(CollectionUtils.isEmpty(existArticles)) {
                    return Result.error();
                }

                int result = articlesMapper.removeCollectiton(collection);
                if(result <= 0) {
                    return Result.error();
                }

                return Result.success();
            }

            default:return Result.error(AppApiCode.params_error);
        }
    }

}
