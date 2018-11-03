package com.rex.onlineShop;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * config spring & junit, Load SpringIOC container when junit start
 */
@RunWith(SpringJUnit4ClassRunner.class)
// tell junit, the position of the spring's configuration
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}
