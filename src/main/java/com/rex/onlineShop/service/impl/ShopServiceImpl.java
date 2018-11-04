package com.rex.onlineShop.service.impl;

import com.rex.onlineShop.dao.ShopDao;
import com.rex.onlineShop.dto.ShopExecution;
import com.rex.onlineShop.entity.Shop;
import com.rex.onlineShop.enums.ShopStateEnum;
import com.rex.onlineShop.exceptions.ShopOperationException;
import com.rex.onlineShop.service.ShopService;
import com.rex.onlineShop.util.ImageUtil;
import com.rex.onlineShop.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    ShopDao shopDao;
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String filename) {
        if(shop == null || shopImgInputStream == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            shop.setStatus(0);
            shop.setCreatedTime(new Date());
            shop.setModifiedTime(new Date());
            int effectedNum = shopDao.insertShop(shop);

            if(effectedNum <= 0){
                // when using Runtime Exception will stop and roll back
                throw new ShopOperationException("add shop error");
            } else {
                try{
                    System.out.println("fileName:" + filename);
                    addShopImg(shop, shopImgInputStream, filename);
                } catch(Exception e){
                    e.printStackTrace();
                    throw new ShopOperationException("add shop img error " + e.getMessage());
                }
                effectedNum = shopDao.updateShop(shop);
                if(effectedNum <= 0){
                    throw new ShopOperationException("add shop img error");
                }
            }
        }catch(Exception e){
            throw new ShopOperationException("add shop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);

    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String filename){
        // get the relative path
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImageAddr = ImageUtil.generateThumbnail(shopImgInputStream, filename, dest);
        shop.setShopImg(shopImageAddr);
    }
}
