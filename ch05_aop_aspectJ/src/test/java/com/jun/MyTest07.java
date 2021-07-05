package com.jun;


import com.jun.bao08.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest07 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        // 目标类无接口使用的是   CGLIB   动态代理
        MyService proxy = (MyService) applicationContext.getBean("myService");
        System.out.println(proxy.getClass().getName());
        proxy.doAfter();
    }
}
