package com.wuyuan.user.controller;

import com.alibaba.fastjson.JSON;
import com.happylifeplat.Result;
import com.happylifeplat.messagecode.impl.AppApiCode;
import com.wuyuan.user.mapper.UserMapper;
import com.wuyuan.user.module.UserDto;
import com.wuyuan.user.module.UserSignInDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by xuwuyuan on 2017/7/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册时候 当用户停止编辑email的时候 检测重复性
     * @param email
     * @return
     */
    @GetMapping("/checkRepeatAccount")
    @ResponseBody
    public Result checkRepeatAccount(String email) {
        if(StringUtils.isEmpty(email)) {
            return Result.error(AppApiCode.params_error);
        }

        List<String> usernames = userMapper.checkRepeatAccout(email);
        if(!CollectionUtils.isEmpty(usernames)) {
            return Result.error();
        }

        return Result.success();
    }

    @PostMapping("/signUp")
    @ResponseBody
    public Result signUp(@RequestBody UserDto user) {
        if(StringUtils.isEmpty(user.getEmail())
                || StringUtils.isEmpty(user.getPassWord())) {
            return Result.error(AppApiCode.params_error);
        }

        if(StringUtils.isEmpty(user.getUserName())) {
            user.setUserName(user.getEmail());
        }

        user.setId(UUID.randomUUID().toString());

        int result = 0;
        try {
            result = userMapper.insertUser(user);
        } catch (Exception e) {
            return Result.error();
        }

        if(result <= 0) {
            return Result.error();
        }

        UserSignInDto signInDto = signIn(user);
        if(signInDto == null) {
            return Result.error();
        }

        return Result.success(signInDto);
    }

    @PostMapping("/signIn")
    @ResponseBody
    public Result userSignIn(@RequestBody UserDto user) {
        if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassWord())) {
            return Result.error();
        }

        UserSignInDto signInDto = signIn(user);
        if(signInDto == null) {
            return Result.error();
        }

        return Result.success(signInDto);
    }

    private UserSignInDto signIn(UserDto user) {
        if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassWord())) {
            return null;
        }

        UserSignInDto signInDto = userMapper.signIn(user);
        logger.info("=============UserController @ signin: " + JSON.toJSON(signInDto));
        return signInDto;
    }

}
