package com.wuyuan.user.controller;

import com.alibaba.fastjson.JSON;
import com.wuyuan.Result;
import com.wuyuan.messagecode.impl.AppApiCode;
import com.wuyuan.user.mapper.UserMapper;
import com.wuyuan.user.module.DeviceInfoDto;
import com.wuyuan.user.module.UserDto;
import com.wuyuan.user.module.UserSignInDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

        // 插入用户
        int result = 0;
        try {
            result = userMapper.insertUser(user);
        } catch (Exception e) {
            return Result.error();
        }

        if(result <= 0) {
            return Result.error();
        }

        // 注册成功登陆
        return signIn(user);
    }

    @PostMapping("/signIn")
    @ResponseBody
    public Result userSignIn(@RequestBody UserDto user) {
        if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassWord())) {
            return Result.error();
        }
        return signIn(user);
    }

    @PostMapping("/anonymous")
    @ResponseBody
    public Result anonymousDeviceInfo(@RequestBody DeviceInfoDto device) {
        if(StringUtils.isEmpty(device.getDeviceId())) {
            return Result.error(AppApiCode.params_error);
        }

        device.setId(UUID.randomUUID().toString());

        DeviceInfoDto info = userMapper.getDeviceInfo(device.getDeviceId());
        if(info == null) {
            int insertResult = userMapper.insertDeviceInfo(device);
            if(insertResult <= 0) {
                return Result.error();
            }
            return Result.success(device);
        }

        info.setProdVersion(device.getProdVersion());
        info.setDevicePlatform(device.getDevicePlatform());
        info.setSystemVersion(device.getSystemVersion());
        userMapper.updateLoginInfo(info);

        return Result.success(info);
    }

    private Result signIn(UserDto user) {
        if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassWord())) {
            return Result.error();
        }

        UserSignInDto signInDto = userMapper.signIn(user);
        logger.info("=============UserController @ signin: " + JSON.toJSON(signInDto));

        if(signInDto == null) {
            return Result.error();
        }

        UserDto lastLogin = new UserDto();
        lastLogin.setId(signInDto.getId());
        lastLogin.setLastLoginTime(new Date());
        userMapper.updateInfo(lastLogin);

        return Result.success(signInDto);
    }

}
