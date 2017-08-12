package com.wuyuan.video.module;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public class Video implements Serializable {
    private static final long serialVersionUID = -2308902003180333254L;

    private String id;
    private String videoUrl;
    private String coverUrl;
    private String title;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    private int like;

}
