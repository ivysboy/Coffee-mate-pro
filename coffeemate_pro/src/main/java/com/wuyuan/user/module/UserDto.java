package com.wuyuan.user.module;

import java.io.Serializable;

/**
 * Created by xuwuyuan on 2017/7/28.
 */

public class UserDto implements Serializable {
    private static final long serialVersionUID = -8458578445930483622L;

    private String id;
    private String userName;
    private String passWord;
    private String email;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
