package com.rex.onlineShop.dao;

import com.rex.onlineShop.BaseTest;
import com.rex.onlineShop.entity.Area;
import com.rex.onlineShop.entity.Shop;
import com.rex.onlineShop.entity.ShopCategory;
import com.rex.onlineShop.entity.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest{
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        UserInfo owner = new UserInfo();
        Area area = new Area();
        ShopCategory sc = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        sc.setShopCatagoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(sc);
        shop.setShopName("TestShop");
        shop.setShopDesc("TestDesc");
        shop.setShopAddr("San Jose");
        shop.setAdvice("checking");
        shop.setPhone("123123");
        shop.setShopImg("01");
        shop.setCreatedTime(new Date());
        shop.setStatus(1);
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(3L);
        shop.setShopDesc("Describe");
        shop.setAdvice("checking");
        shop.setCreatedTime(new Date());
        shop.setModifiedTime(new Date());
        shop.setStatus(0);
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }
    @Test
    public void testQueryByShopId(){
        long shopId = 3L;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId = " + shop.getArea().getAreaId());
        System.out.println("shopId =" + shop.getShopId());
        System.out.println("CreatedTime = " + shop.getCreatedTime());
    }


}
