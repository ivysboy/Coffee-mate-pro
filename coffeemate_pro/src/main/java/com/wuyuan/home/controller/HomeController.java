package com.wuyuan.home.controller;

import com.happylifeplat.Result;
import com.happylifeplat.plugin.mybatis.pager.PageParameter;
import com.wuyuan.config.ApolloCoffeeMateConfig;
import com.wuyuan.home.mapper.ArticlesMapper;
import com.wuyuan.home.mapper.HomeMapper;
import com.wuyuan.home.module.ArticleListDto;
import com.wuyuan.home.module.BannerDto;
import com.wuyuan.home.module.GeneralRequestDto;
import com.wuyuan.home.module.HomeContentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by xuwuyuan on 2017/7/30.
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeMapper homeMapper;

    @Autowired
    private ArticlesMapper articlesMapper;

    @Autowired
    private ApolloCoffeeMateConfig apolloCoffeeMateConfig;

    @GetMapping("/banner")
    @ResponseBody
    public Result getBanner() {

        BannerDto banner = homeMapper.getHomeBanner();
        return Result.success(banner);
    }

    @GetMapping("/contentList")
    @ResponseBody
    public Result getContentList() {
        List<HomeContentDto> contentList = homeMapper.getHomeContentList();
        if(CollectionUtils.isEmpty(contentList)) {
            return Result.success(new ArrayList<>());
        }

        for(HomeContentDto content: contentList) {
            GeneralRequestDto articleRequest = new GeneralRequestDto();
            PageParameter page = new PageParameter();
            page.setCurrentPage(1);
            page.setPageSize(7);
            articleRequest.setGroupId(content.getGroupId());
            articleRequest.setOrderBy("-createtime");
            articleRequest.setPage(page);
            List<ArticleListDto> articleList = articlesMapper.getArticlesPage(articleRequest);
            articleList.forEach(article -> {
                article.setImage(apolloCoffeeMateConfig.getImagePrefix() + article.getImage());
            });
            content.setArticleList(articleList);
        }

        Collections.sort(contentList, Comparator.comparing(HomeContentDto :: getIndex));
        return Result.success(contentList);
    }
}
