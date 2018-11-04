package com.rex.onlineShop.exceptions;

public class ShopOperationException extends RuntimeException {

    private static final long serialVersionUID = 8561566779892597750L;

    public ShopOperationException(String errorMessage){
        super(errorMessage);

    }
}
