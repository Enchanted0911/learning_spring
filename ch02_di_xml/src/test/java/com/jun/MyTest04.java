package com.jun;

import com.jun.bao04.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    @Test
    public void test01() {
        // 使用spring容器创建对象
        // 1. 指定spring文件配置名称
        String config = "bao04/applicationContext.xml";
        // 2. 创建表示spring容器的对象, ApplicationContext
        // ClassPathXmlApplicationContext : 表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // getBean("id值")
        var myStudent = (Student) ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
