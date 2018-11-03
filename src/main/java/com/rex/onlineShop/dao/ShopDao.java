package com.rex.onlineShop.dao;

import com.rex.onlineShop.entity.Shop;

public interface ShopDao {
    /**
     * Add new shop
     * @param shop shop
     * @return status
     */
    int insertShop(Shop shop);

    /**
     * update the shop info
     * @param shop shop
     * @return result
     */
    int updateShop(Shop shop);
}
