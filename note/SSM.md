# SSM
## Spring
- Configuration
  - Spring-dao.xml
  - Spring-service.xml
  - Spring-web.xml
- CommonMultipartFile 
    - Spring using CommonMultiplePartFile to get upload file,by using code below:
 ``` java
CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }
 ```

   - CommonMultiplePartFile convert to File using CommonMultiplePartFile.getInputStream as a intermediate.
## SpringMVC
## Mybatis
- Configuration
  - jdbc.properties
  - Mybatis-config.xml
- Dynamic generate SQL statement
  - Generate SQL statement when the condition is true
  ``` XML
  <update id = "updateShop" parameterType="com.rex.onlineShop.entity.Shop">
        UPDATE tb_shop
        <set>
            <if test="shopName != null">shop_name = #{shopName},</if>
            <if test="shopDesc != null">shop_desc = #{shopDesc},</if>
            <if test="shopAddr != null">shop_addr = #{shopAddr},</if>
            <if test="phone != null">phone = #{phone},</if>
            <if test="priority != null">priority = #{priority},</if>
            <if test="shopImg != null">shop_img = #{shopImg},</if>
            <if test="advice != null">advice = #{advice},</if>
            <if test="status != null">status = #{status},</if>
            <if test="modifiedTime != null">modified_time = #{modifiedTime},</if>
            <if test="area != null">area_id = #{area.areaId},</if>
            <if test="shopCategory != null">shop_catagroy_id = #{shopCategory.shopCatagoryId}</if>
        </set>
        where shop_id = #{shopId}
    </update>
  ```
## Procedure
### Dao
- Create a specific interface(AreaDao) of a Dao and add a method in it.
- In **Mapper** forlder add a xml file with the same name of the Interface.
  ``` XML
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE mapper
          PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <mapper namespace="<Interface Path>">
      <select id =<Method Name>" resultType="<Result type Path>">
        <SQL statment>
      </select>
  </mapper>
  ```
### Service
- Add a specific service interface(AreaService)
- Create a implementation of the service(AreaServiceImpl) and add @Service annotation on
- Add @Transactional annotation above the method, the method will be a transaction.
- **Transaction will only roll back when it meets the RuntimeException**
- Use @AutoWired annotation to inject the Dao object, Override the method

### Controller
- Create a controller Class(AreaController)
- Add the @Controller and @RequestMapping Annotation above the class
- Use @AutoWired to inject the service object in
- Attach a @RequestMapping above the method with the URL and the Request Method(value = "/xxx", method = RequestMethod.GET)
- Add @ResponseBody to make the response in JSON format
- Write the logic and return a HashMap(key is status, value is the object)
