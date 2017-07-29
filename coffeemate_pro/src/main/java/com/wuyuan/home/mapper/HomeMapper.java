package com.wuyuan.home.mapper;

import com.wuyuan.home.module.ArticleListDto;
import com.wuyuan.home.module.BannerDto;
import com.wuyuan.home.module.HomeContentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public interface HomeMapper {

    BannerDto getHomeBanner();

    List<HomeContentDto> getHomeContentList();
}
