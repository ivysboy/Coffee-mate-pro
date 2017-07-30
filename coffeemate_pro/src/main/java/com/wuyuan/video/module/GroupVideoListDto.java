package com.wuyuan.video.module;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public class GroupVideoListDto implements Serializable {
    private static final long serialVersionUID = 6788118085050212013L;

    private String id;
    private String title;
    private int index;
    private List<Video> videos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
