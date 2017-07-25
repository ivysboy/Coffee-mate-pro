package com.wuyuan.util.module;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuwuyuan on 2017/7/20.
 */
public class ArticleDto implements Serializable {
    private static final long serialVersionUID = -4038501243008079177L;

    private String id;
    private String name;
    private String content;
    private Date createTime;
    private String brief;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
