package com.rex.onlineShop.enums;


public enum ShopStateEnum {
    CHECK(0,"Checking"), OFFLINE(-1, "Illegal"),
    SUCCESS(1,"Success"), PASS(2,"Pass"),
    INNER_ERROR(-1001,"Inner Error"), NULL_SHOPID(-1002,"Shop Id is Null"),
    NULL_SHOP(-1003,"Null shop");

    private int state;
    private String stateInfo;

    // don't want third party modify this enum, so use private here
    private ShopStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopStateEnum stateOf(int state){
        for(ShopStateEnum stateEnum: values()){
            if(stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
