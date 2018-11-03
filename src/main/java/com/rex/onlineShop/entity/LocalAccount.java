package com.rex.onlineShop.entity;

import java.util.Date;

public class LocalAccount {
    private Long localAccountId;
    private String username;
    private String password;
    private Date createdTime;
    private Date modifiedTime;
    private UserInfo userInfo;

    public Long getLocalAccountId() {
        return localAccountId;
    }

    public void setLocalAccountId(Long localAccountId) {
        this.localAccountId = localAccountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
