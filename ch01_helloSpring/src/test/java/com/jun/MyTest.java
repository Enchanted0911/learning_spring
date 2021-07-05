package com.jun;

import com.jun.bao02.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MyTest {
    @Test
    public void test01() {
        // 使用spring容器创建对象
        // 1. 指定spring文件配置名称
        String config = "beans.xml";
        // 2. 创建表示spring容器的对象, ApplicationContext
        // ClassPathXmlApplicationContext : 表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // getBean("id值")
        var myService = (MyService) ac.getBean("myService");
        myService.doSome();
    }

    @Test
    public void test02() {
        // 使用spring容器创建对象
        // 1. 指定spring文件配置名称
        String config = "beans.xml";
        // 2. 创建表示spring容器的对象, ApplicationContext
        // ClassPathXmlApplicationContext : 表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        int num = ac.getBeanDefinitionCount();
        System.out.println("num = " + num);

        String[] names = ac.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
    }
}
