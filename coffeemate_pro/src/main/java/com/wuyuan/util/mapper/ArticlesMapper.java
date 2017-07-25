package com.wuyuan.util.mapper;

import com.wuyuan.util.module.ArticleDto;
import com.wuyuan.util.module.GeneralRequestDto;
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

    /**
     * 通过id获取文章
     * @param id
     * @return
     */
    ArticleDto getArticleById(@Param("id") String id);

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    int updateArticle(ArticleDto article);
}
