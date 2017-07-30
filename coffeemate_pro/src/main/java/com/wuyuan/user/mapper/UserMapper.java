package com.wuyuan.user.mapper;

import com.wuyuan.user.module.DeviceInfoDto;
import com.wuyuan.user.module.UserDto;
import com.wuyuan.user.module.UserSignInDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/28.
 */
public interface UserMapper {

    List<String> checkRepeatAccout(@Param("email") String email);

    int insertUser(UserDto user);

    UserSignInDto signIn(UserDto request);

    int updateInfo(UserDto request);

    DeviceInfoDto getDeviceInfo(@Param("deviceId") String deviceId);

    int insertDeviceInfo(DeviceInfoDto device);

    int updateLoginInfo(@Param("id") String deviceId, @Param("prodVersion") String prodVersion);
}
