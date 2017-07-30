package com.wuyuan.video.module;

import java.io.Serializable;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public class VideoGroupDto implements Serializable {
    private static final long serialVersionUID = 6788118085050212013L;

    private String id;
    private String name;
    private int index;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
