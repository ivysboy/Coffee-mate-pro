package com.wuyuan.video.controller;

import com.wuyuan.Result;
import com.wuyuan.plugin.mybatis.pager.PageParameter;
import com.wuyuan.home.module.GeneralRequestDto;
import com.wuyuan.video.mapper.VideoMapper;
import com.wuyuan.video.module.GroupVideoListDto;
import com.wuyuan.video.module.Video;
import com.wuyuan.video.module.VideoGroupDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //todo: 还要做插入视频记录的接口
    //todo: 上传视频的接口
    //todo: 插入视频分组记录的接口

    @GetMapping("/getVideoList")
    @ResponseBody
    public Result getVideoList() {
        PageParameter pageParameter = new PageParameter();
        pageParameter.setCurrentPage(1);
        pageParameter.setPageSize(4);

        List<VideoGroupDto> videoGroups = videoMapper.getVideoGroups();
        List<GroupVideoListDto> result = new ArrayList<>();
        videoGroups.forEach(videoGroup -> {
            GeneralRequestDto requestDto = new GeneralRequestDto();
            requestDto.setPage(pageParameter);
            requestDto.setGroupId(videoGroup.getId());
            requestDto.setOrderBy("-createtime");
            List<Video> videos = videoMapper.getVideoListPage(requestDto);

            if(!CollectionUtils.isEmpty(videos)) {
                GroupVideoListDto groupVideo = new GroupVideoListDto();
                groupVideo.setId(videoGroup.getId());
                groupVideo.setIndex(videoGroup.getIndex());
                groupVideo.setTitle(videoGroup.getName());
                groupVideo.setVideos(videos);
                result.add(groupVideo);
            }
        });

        return Result.success(result);
    }

    @GetMapping("/getVideoListByGroupId")
    @ResponseBody
    public Result getVideoListByGroupId(int page, @RequestParam String groupId) {
        if(page == 0) {
            page = 1;
        }

        PageParameter pageParameter = new PageParameter();
        pageParameter.setCurrentPage(page);

        GeneralRequestDto requestDto = new GeneralRequestDto();
        requestDto.setPage(pageParameter);
        requestDto.setOrderBy("-createtime");
        requestDto.setGroupId(groupId);

        List<Video> videoList = videoMapper.getVideoListPage(requestDto);
        return Result.success(videoList);
    }
}
