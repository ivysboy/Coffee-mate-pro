package com.wuyuan.home.module;

import java.io.Serializable;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public class ArticleListDto implements Serializable {

    private static final long serialVersionUID = -5230850767116846086L;

    private String id;
    private String title;
    private String auther;
    private String brief;
    private String image;

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

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
