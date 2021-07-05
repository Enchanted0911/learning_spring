package com.jun;

import com.jun.bao04.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        MyService proxy = (MyService) applicationContext.getBean("myService");
        proxy.doException();
    }
}
