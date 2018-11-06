# SpringBoot
- When **SpringApplication.run** will scan all packages!
## Configuration
- application.properties: has a lot of built-in properties
- pom.xml: has all dependencies with spring and mybatis
- All configs are under [config](../src/main/java/com/rex/onlineShopSpringBoot/config)
## Immigration
- Copy **jdbc.properties** to **application.properties**
- Copy logback.xml, mybatis-config.xml under the resources folder
- Create Config package and some configuration classes for the **bean**.
  - @Configuration annotation means that this configuration will be added into the spring IOC containter
  - String using for configuration should be written into the application.properties withou quotes.
  - Fields should be read from application.properties by @Value annotation.
  - static field should use setter method
  - Attach @Bean(name = "<Bean Name>") annotation on the method
  - Return type is the class written in the previous xml file
  - @EnableTransactionManagement is used to support the transcation, after attached this, @transactional can be used
