package com.wuyuan.jpush.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by xuwuyuan on 2017/8/10.
 */
@Service("pushJobService")
public class PushJobHandler implements PushJobService {

    private static final String PUSH_JOB_KEY = "TEST_PUSH_JOB_KEY";

    private static final Logger log = LoggerFactory.getLogger(PushJobHandler.class);

    public void createSchedulerJob() {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {

            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(PushJob.class)
                    .withIdentity(PushJob.ID, PushJob.GROUP)
                    .build();

            jobDetail.getJobDataMap().put(PushJob.ID, PUSH_JOB_KEY);

            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(24).repeatForever();
            TriggerKey triggerKey = TriggerKey.triggerKey(PUSH_JOB_KEY, PushJob.GROUP);

            Date fireDate = new Date(new Date().getTime() + 1000 * 20);
            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                    .startAt(fireDate)
                    .withIdentity(triggerKey)
                    .withSchedule(simpleScheduleBuilder)
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (Exception e) {
            log.error("============get scheduler error : " + e.getMessage());
        }

    }
}
