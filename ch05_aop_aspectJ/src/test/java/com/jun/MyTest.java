package com.jun;

import com.jun.bao01.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        MyService proxy = (MyService) applicationContext.getBean("myService");
        proxy.doSome("vanessa", 18);
    }
}
