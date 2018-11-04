package com.rex.onlineShop.web.shopAdmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rex.onlineShop.dto.ShopExecution;
import com.rex.onlineShop.entity.Shop;
import com.rex.onlineShop.entity.UserInfo;
import com.rex.onlineShop.enums.ShopStateEnum;
import com.rex.onlineShop.service.ShopService;
import com.rex.onlineShop.util.HTTPServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shopAdmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        // 1. Receive and convert params of shops and img
        String shopStr = HTTPServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errorMessage", e.getMessage());
            return modelMap;
        }
        // using CommonsMultipartFile upload file
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        } else {
            modelMap.put("success",false);
            modelMap.put("errorMessage", "upload image cannot be null");
            return modelMap;
        }
        // 2. register shop
        if(shop != null){
            UserInfo owner = new UserInfo();
            //TODO: using session to extract user id
            owner.setUserId(1L);
            shop.setOwner(owner);

            ShopExecution se = null;
            try {
                se = shopService.addShop(shop, shopImg.getInputStream(),shopImg.getOriginalFilename());
                if(se.getState() == ShopStateEnum.CHECK.getState()){
                    modelMap.put("success",true);
                } else {
                    modelMap.put("success",false);
                    modelMap.put("errorMessage", se.getStateInfo());
                }
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errorMessage", "shop info is not completed");
            }
            return modelMap;
        } else {
            modelMap.put("success",false);
            modelMap.put("errorMessage", "shop info is not completed");
            return modelMap;
        }
    }
}
