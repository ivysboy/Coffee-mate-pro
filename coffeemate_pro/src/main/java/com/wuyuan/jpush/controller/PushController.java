package com.wuyuan.jpush.controller;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;

/**
 * Created by xuwuyuan on 2017/8/2.
 */
@RestController
@RequestMapping("/push")
public class PushController {

    private static final String MASTER_SECRET = "f05eb2edd236fdbab678dac4";
    private static final String APP_KEY = "f9e0b3b422f675e0f176d2fe";

    private static final Logger log = LoggerFactory.getLogger(PushController.class);
    private static final JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

    @GetMapping("/pushAlert")
    @ResponseBody
    public void pushAllAlert() {
        PushPayload payload = buildPushObject_all_alias_alert();

        try {
            PushResult result = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            log.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
            log.error("Should review the error, and fix the request", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
        }
    }

    private static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll(ALERT);
    }

    private static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("coffe-mate"))
                .setNotification(Notification.alert(ALERT))
                .build();
    }
}
