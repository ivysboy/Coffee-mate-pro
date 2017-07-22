package com.wuyuan.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuwuyuan on 2017/7/23.
 */
@Configuration
@ConfigurationProperties(prefix = "server", locations = "classpath:config/server.properties")
public class ServerSetting {
    private String imagePrefix;
    private String imageContentPath;
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
