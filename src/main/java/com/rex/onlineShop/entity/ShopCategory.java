package com.rex.onlineShop.entity;

import java.util.Date;

public class ShopCategory {
    private Long shopCatagoryId;
    private String shopCatagoryName;
    private String shopCatagoryDesc;
    private String shopCatagoryImg;
    private Integer priority;
    private Date createdTime;
    private Date modifiedTime;
    private ShopCategory parent;

    public Long getShopCatagoryId() {
        return shopCatagoryId;
    }

    public void setShopCatagoryId(Long shopCatagoryId) {
        this.shopCatagoryId = shopCatagoryId;
    }

    public String getShopCatagoryName() {
        return shopCatagoryName;
    }

    public void setShopCatagoryName(String shopCatagoryName) {
        this.shopCatagoryName = shopCatagoryName;
    }

    public String getShopCatagoryDesc() {
        return shopCatagoryDesc;
    }

    public void setShopCatagoryDesc(String shopCatagoryDesc) {
        this.shopCatagoryDesc = shopCatagoryDesc;
    }

    public String getShopCatagoryImg() {
        return shopCatagoryImg;
    }

    public void setShopCatagoryImg(String shopCatagoryImg) {
        this.shopCatagoryImg = shopCatagoryImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public ShopCategory getParent() {
        return parent;
    }

    public void setParent(ShopCategory parent) {
        this.parent = parent;
    }
}
