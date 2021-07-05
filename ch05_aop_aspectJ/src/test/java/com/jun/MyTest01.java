package com.jun;

import com.jun.bao02.MyService;
import com.jun.bao02.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        MyService proxy = (MyService) applicationContext.getBean("myService");
        String str = proxy.doOther();
        System.out.println(str);
    }

    @Test
    public void test02() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        MyService proxy = (MyService) applicationContext.getBean("myService");
        Student student = (Student) applicationContext.getBean("myStudent");
        Student student1 = proxy.doOther2(student);
        System.out.println(student1);
    }
}
