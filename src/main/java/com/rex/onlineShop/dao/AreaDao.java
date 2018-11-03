package com.rex.onlineShop.dao;

import com.rex.onlineShop.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * list the area list
     * @return area list
     */
    List<Area> queryArea();
}
