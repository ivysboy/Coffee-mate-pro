package com.wuyuan.Controller;

import com.happylifeplat.Result;
import com.happylifeplat.messagecode.impl.CommonCode;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xuwuyuan on 2017/7/18.
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @RequestMapping(value = "/commonResponse/{testKey}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result getCommonResponse(@PathVariable String testKey) {
        List<String> commonStrs = new ArrayList<>();
        for(int i = 0; i< 10; i++) {
            Random random = new Random();
            Integer num = random.nextInt(200);
            commonStrs.add(num.toString());
        }
        return new Result(CommonCode.sussess, commonStrs);
    }
}
