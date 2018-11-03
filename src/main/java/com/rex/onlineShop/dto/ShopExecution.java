package com.rex.onlineShop.dto;

import com.rex.onlineShop.entity.Shop;
import com.rex.onlineShop.enums.ShopStateEnum;

import java.util.List;

public class ShopExecution {
    // the result state
    private int state;

    // state info
    private String stateInfo;

    // shop count
    private int count;

    // shop
    private Shop shop;

    // the result of the select
    private List<Shop> shopList;

    public ShopExecution(){

    }


    /**
     *  constructor when operation failed
     * @param stateEnum state
     */
    public ShopExecution(ShopStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     *  constructor when operation success
     * @param stateEnum state
     * @param stateEnum shop
     */
    public ShopExecution(ShopStateEnum stateEnum, Shop shop){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     * constructor when operation success
     * @param stateEnum state
     * @param shopList shop List
     */
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
