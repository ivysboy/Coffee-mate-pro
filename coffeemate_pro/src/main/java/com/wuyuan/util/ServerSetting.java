package com.wuyuan.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuwuyuan on 2017/7/23.
 */
@Configuration
public class ServerSetting {

    @Value("${server.imagePrefix}")
    private String imagePrefix;

    @Value("${server.imageContentPath}")
    private String imageContentPath;

    @Value("${server.imageStorePath}")
    private String imageStorePath;

    public String getImageStorePath() {
        return imageStorePath;
    }

    public void setImageStorePath(String imageStorePath) {
        this.imageStorePath = imageStorePath;
    }

    public String getImageContentPath() {
        return imageContentPath;
    }

    public void setImageContentPath(String imageContentPath) {
        this.imageContentPath = imageContentPath;
    }

    public String getImagePrefix() {
        return imagePrefix;
    }

    public void setImagePrefix(String imagePrefix) {
        this.imagePrefix = imagePrefix;
    }
}
