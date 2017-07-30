package com.wuyuan.user.module;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public class DeviceInfoDto implements Serializable {

    private static final long serialVersionUID = 96298378627642356L;

    private String id;
    private String deviceId;
    private String devicePlatform;
    private String systemVersion;
    private String prodVersion;
    private Date lastLoginTime;

    public String getProdVersion() {
        return prodVersion;
    }

    public void setProdVersion(String prodVersion) {
        this.prodVersion = prodVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDevicePlatform() {
        return devicePlatform;
    }

    public void setDevicePlatform(String devicePlatform) {
        this.devicePlatform = devicePlatform;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
