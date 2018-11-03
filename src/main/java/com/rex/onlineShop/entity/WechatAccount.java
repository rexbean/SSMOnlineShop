package com.rex.onlineShop.entity;

import java.util.Date;

public class WechatAccount {

    private Long wechatAccountId;
    private String openId;
    private Date createdTime;
    private UserInfo userInfo;

    public Long getWechatAccountId() {
        return wechatAccountId;
    }

    public void setWechatAccountId(Long wechatAccountId) {
        this.wechatAccountId = wechatAccountId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
