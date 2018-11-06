package com.rex.onlineShop.service;

import com.rex.onlineShop.dto.ShopExecution;
import com.rex.onlineShop.entity.Shop;
import com.rex.onlineShop.exceptions.ShopOperationException;
import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;

public interface ShopService {

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String Filename);

    Shop getShopById(long shopId);

    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String filename) throws ShopOperationException;
}
