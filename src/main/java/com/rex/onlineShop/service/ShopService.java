package com.rex.onlineShop.service;

import com.rex.onlineShop.dto.ShopExecution;
import com.rex.onlineShop.entity.Shop;
import java.io.InputStream;

public interface ShopService {

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String Filename);
}
