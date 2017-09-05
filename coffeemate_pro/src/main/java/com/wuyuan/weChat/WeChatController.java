package com.wuyuan.weChat;

import com.happylifeplat.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuwuyuan on 2017/9/5.
 */
@RestController
@RequestMapping("/wx")
public class WeChatController {

    private static final Logger log = LoggerFactory.getLogger(WeChatController.class);

    @GetMapping("/test")
    public Result testApi() {
        return Result.success();
    }
}
