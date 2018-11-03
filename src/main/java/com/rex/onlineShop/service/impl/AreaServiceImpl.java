package com.rex.onlineShop.service.impl;

import com.rex.onlineShop.dao.AreaDao;
import com.rex.onlineShop.entity.Area;
import com.rex.onlineShop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
