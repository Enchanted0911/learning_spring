package com.jun;

import com.jun.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        BuyGoodsService buyGoodsService = (BuyGoodsService) applicationContext.getBean("buyGoodsService");
        buyGoodsService.buy(1001, 200);
    }
}
