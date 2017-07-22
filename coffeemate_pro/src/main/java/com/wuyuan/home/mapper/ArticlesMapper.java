package com.wuyuan.home.mapper;

import com.happylifeplat.plugin.mybatis.pager.PageParameter;
import com.wuyuan.home.module.ArticleDto;
import com.wuyuan.home.module.GeneralRequestDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/22.
 */
public interface ArticlesMapper {

    /**
     * 插入一条文章信息
     * @param article
     * @return
     */
    int insertArticle(ArticleDto article);

    /**
     * 分页获取文章列表
     * @param requestDto
     * @return
     */
    List<ArticleDto> getArticlesPage(GeneralRequestDto requestDto);
}
