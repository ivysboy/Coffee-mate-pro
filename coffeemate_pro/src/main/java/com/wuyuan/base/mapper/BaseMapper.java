package com.wuyuan.base.mapper;

import com.wuyuan.base.module.ArticleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/20.
 */
public interface BaseMapper {

    List<ArticleDto> getArticles(@Param("id") String id);
}
