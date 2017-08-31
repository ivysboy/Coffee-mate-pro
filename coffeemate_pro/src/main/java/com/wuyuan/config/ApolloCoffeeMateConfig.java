package com.wuyuan.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuwuyuan on 2017/8/31.
 */
@Configuration
public class ApolloCoffeeMateConfig {

    private static final Logger log = LoggerFactory.getLogger(ApolloCoffeeMateConfig.class);

    @ApolloConfig
    private Config config;

    @Value("${server.imagePrefix}")
    private String imagePrefix;

    @Value("${server.imageContentPath}")
    private String imageContentPath;

    @Value("${server.imageStorePath}")
    private String imageStorePath;

    @ApolloConfigChangeListener("application")
    private void propChangeHandler(ConfigChangeEvent changeEvent) {
        log.info("changeEvent = [" + changeEvent.toString() + "]");
        if(changeEvent.isChanged("server.imagePrefix")) {
            imagePrefix = config.getProperty("server.imagePrefix", imagePrefix);
        } else if (changeEvent.isChanged("server.imageContentPath")) {
            imageContentPath = config.getProperty("server.imageContentPath", imageContentPath);
        } else if (changeEvent.isChanged("server.imageStorePath")) {
            imageStorePath = config.getProperty("server.imageStorePath", imageStorePath);
        }
    }

    public String getImagePrefix() {
        return config.getProperty("server.imagePrefix", imagePrefix);
    }

    public String getImageContentPath() {
        return config.getProperty("server.imageContentPath", imageContentPath);
    }

    public String getImageStorePath() {
        return config.getProperty("server.imageStorePath", imageStorePath);
    }
}
