package com.wuyuan.jpush.service;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;

/**
 * Created by xuwuyuan on 2017/8/10.
 */
@Service("pushActionService")
public class PushServiceImpl implements PushService {

    private static final String MASTER_SECRET = "f05eb2edd236fdbab678dac4";
    private static final String APP_KEY = "f9e0b3b422f675e0f176d2fe";

    private static final Logger log = LoggerFactory.getLogger(PushServiceImpl.class);
    private static final JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

    public PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.all())
                .setNotification(Notification.alert("咖啡伴我心，让精品咖啡走进你的生活！"))
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                .build();
    }

    @Override
    public PushResult sendPush(PushPayload pushPayload) {

        PushResult result = null;
        try {
            result = jpushClient.sendPush(pushPayload);
        } catch (APIConnectionException e) {
            log.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
            log.error("Should review the error, and fix the request", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
        }

        return result;
    }
}
