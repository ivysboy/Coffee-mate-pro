package com.wuyuan.base.Controller;

import com.happylifeplat.Result;
import com.happylifeplat.messagecode.impl.CommonCode;
import com.wuyuan.base.mapper.BaseMapper;
import com.wuyuan.home.module.ArticleDto;
import com.wuyuan.base.module.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BaseMapper baseMapper;

    @RequestMapping(value = "/commonResponse/{testKey}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result getCommonResponse(@PathVariable String testKey) {
        List<String> commonStrs = new ArrayList<>();
        for(int i = 0; i< 20; i++) {
            Random random = new Random();
            Integer num = random.nextInt(20);
            commonStrs.add(num.toString());
        }

        CommonVO vo = new CommonVO();
        vo.setName("my vps test vo");
        vo.setValues(commonStrs);

        List<ArticleDto> articles = baseMapper.getArticles(testKey);

        return new Result(CommonCode.sussess, articles);
    }

    @GetMapping("/testApi")
    public Result getTestApi() {
        return Result.success("测试接口6666666测试接口");
    }
}
