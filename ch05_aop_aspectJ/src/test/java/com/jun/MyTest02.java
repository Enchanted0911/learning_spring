package com.jun;

import com.jun.bao03.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        MyService proxy = (MyService) applicationContext.getBean("myService");
        String str = proxy.doFirst("vanessa", 18);
        System.out.println(str);
    }
}
