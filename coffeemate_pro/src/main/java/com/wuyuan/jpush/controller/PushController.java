package com.wuyuan.jpush.controller;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;
import com.happylifeplat.Result;
import com.wuyuan.jpush.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private PushService pushService;

    @GetMapping("/pushAlert")
    @ResponseBody
    public Result pushAllAlert() {
        PushPayload payload = pushService.buildPushObject_all_alias_alert();

        pushService.sendPush(payload);

        return Result.success();
    }

}
