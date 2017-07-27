package com.wuyuan.user.module;

import java.io.Serializable;

/**
 * Created by xuwuyuan on 2017/7/28.
 */
public class UserSignInDto implements Serializable {
    private static final long serialVersionUID = -7567479544251764075L;

    private String id;
    private String userName;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
