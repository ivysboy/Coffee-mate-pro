package com.wuyuan.video.controller;

import com.happylifeplat.Result;
import com.happylifeplat.plugin.mybatis.pager.PageParameter;
import com.wuyuan.home.module.GeneralRequestDto;
import com.wuyuan.video.mapper.VideoMapper;
import com.wuyuan.video.module.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private VideoMapper videoMapper;

    @GetMapping("/getVideoList")
    @ResponseBody
    public Result getVideoList(int page) {
        if(page == 0) {
            page = 1;
        }

        PageParameter pageParameter = new PageParameter();
        pageParameter.setCurrentPage(page);

        GeneralRequestDto requestDto = new GeneralRequestDto();
        requestDto.setPage(pageParameter);
        requestDto.setOrderBy("-create_time");

        List<Video> videoList = videoMapper.getVideoList(requestDto);
        return Result.success(videoList);
    }
}
