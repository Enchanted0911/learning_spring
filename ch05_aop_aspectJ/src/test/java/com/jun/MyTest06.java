package com.jun;

import com.jun.bao07.MyServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        // 目标类无接口使用的是   CGLIB   动态代理
        MyServiceImpl proxy = (MyServiceImpl) applicationContext.getBean("myService");
        proxy.doSome("vanessa", 18);
    }
}
