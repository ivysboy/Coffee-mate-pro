package com.wuyuan.video.mapper;

import com.wuyuan.home.module.GeneralRequestDto;
import com.wuyuan.video.module.Video;

import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public interface VideoMapper {

    List<Video> getVideoList(GeneralRequestDto requestDto);
}
