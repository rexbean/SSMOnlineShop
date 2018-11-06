package com.rex.onlineShop.dao;

import com.rex.onlineShop.BaseTest;
import com.rex.onlineShop.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        if(areaDao == null){
            System.out.println("it is null here");
        }
        List<Area> areaList = areaDao.queryArea();
        if(areaList == null){
            System.out.println("it is null here2");
        }
        assertEquals(2, areaList.size());
    }
}
