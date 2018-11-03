package com.rex.onlineShop.entity;

import java.util.Date;

public class ProductCatagory {
    private Long productCatagoryId;
    private Long shopId;
    private String productCatagoryName;
    private Integer priority;
    private Date createdTime;

    public Long getProductCatagoryId() {
        return productCatagoryId;
    }

    public void setProductCatagoryId(Long productCatagoryId) {
        this.productCatagoryId = productCatagoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductCatagoryName() {
        return productCatagoryName;
    }

    public void setProductCatagoryName(String productCatagoryName) {
        this.productCatagoryName = productCatagoryName;
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
}
