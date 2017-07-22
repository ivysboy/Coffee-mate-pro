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

    public String getImagePrefix() {
        return imagePrefix;
    }

    public void setImagePrefix(String imagePrefix) {
        this.imagePrefix = imagePrefix;
    }
}
