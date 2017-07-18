package com.wuyuan.Controller;

import com.happylifeplat.Result;
import com.happylifeplat.messagecode.impl.CommonCode;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xuwuyuan on 2017/7/18.
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @RequestMapping(value = "/commonResponse/{testKey}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result getCommonResponse(@PathVariable String testKey) {
        return new Result(CommonCode.sussess, testKey);
    }
}
