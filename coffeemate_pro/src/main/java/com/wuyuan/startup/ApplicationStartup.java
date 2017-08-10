package com.wuyuan.startup;

import com.wuyuan.jpush.job.PushJobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by xuwuyuan on 2017/8/10.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private PushJobHandler pushJobService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        pushJobService.createSchedulerJob();
    }
}
