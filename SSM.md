# SSM
## Spring
- Configuartion
  - Spring-dao.xml
  - Spring-service.xml
  - Spring-web.xml
## SpringMVC
## Mybatis
- Configuration
  - jdbc.properties
  - Mybatis-config.xml
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
- Use @AutoWired annotation to inject the Dao object, Override the method
### Controller
- Create a controller Class(AreaController)
- Add the @Controller and @RequestMapping Annotation above the class
- Use @AutoWired to inject the service object in
- Attach a @RequestMapping above the method with the URL and the Request Method(value = "/xxx", method = RequestMethod.GET)
- Add @ResponseBody to make the response in JSON format
- Write the logic and return a HashMap(key is status, value is the object)
