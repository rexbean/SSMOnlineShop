package com.rex.onlineShop.service;

import com.rex.onlineShop.BaseTest;
import com.rex.onlineShop.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("east", areaList.get(0).getAreaName());
    }
}
