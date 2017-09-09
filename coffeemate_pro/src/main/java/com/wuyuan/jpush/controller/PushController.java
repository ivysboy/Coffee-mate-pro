package com.wuyuan.jpush.controller;

import cn.jpush.api.push.model.PushPayload;
import com.wuyuan.Result;
import com.wuyuan.jpush.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xuwuyuan on 2017/8/2.
 */
@RestController
@RequestMapping("/push")
public class PushController {

    private static final Logger log = LoggerFactory.getLogger(PushController.class);

    @Autowired
    private PushService pushService;

    @GetMapping("/pushNow")
    @ResponseBody
    public Result pushAllAlert(@RequestParam String content) {

        log.info("=================send notification of : " + content);
        PushPayload payload = pushService.buildPushObject(content);

        pushService.sendPush(payload);

        return Result.success();
    }
}
