package com.wuyuan.jpush.job;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.wuyuan.util.Constant;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Created by xuwuyuan on 2017/8/10.
 */
public class PushJob implements Job {

    private static final JPushClient jpushClient = new JPushClient(Constant.JPUSH_MASTER_SECRET, Constant.JPUSH_APP_KEY, null, ClientConfig.getInstance());

    public static final String ID = "PushJobId";
    public static final String GROUP = "PushJobGroup";

    private static final Logger log = LoggerFactory.getLogger(PushJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String id = jobDataMap.getString(ID);

        if(!StringUtils.isEmpty(id)) {
            log.info("================执行任务开始");
            PushPayload payload = buildPushObject("咖啡伴我心，让精品咖啡走进你的生活！");
            sendPush(payload);
        } else {
            log.error("================执行推送任务失败");
        }
    }

    public PushPayload buildPushObject(String content) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.alert(content))
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                .build();
    }


    public PushResult sendPush(PushPayload pushPayload) {

        PushResult result = null;
        try {
            result = jpushClient.sendPush(pushPayload);
        } catch (APIConnectionException e) {
            log.error("aConnection error, should retry later", e);
        } catch (APIRequestException e) {
            log.error("Should review the error, and fix the request", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
        }

        return result;
    }
}
