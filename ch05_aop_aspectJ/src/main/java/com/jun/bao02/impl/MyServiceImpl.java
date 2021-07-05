package com.jun.bao02.impl;

import com.jun.bao02.MyService;
import com.jun.bao02.domain.Student;
import org.springframework.stereotype.Component;

/**
 * @author Wu
 */
@Component("myService")
public class MyServiceImpl implements MyService {
    @Override
    public void doSome(String name, Integer age) {
        System.out.println("不知道该干点什么");
    }

    @Override
    public String doOther() {
        System.out.println("后置通知方法执行");
        return "vanessa";
    }

    @Override
    public Student doOther2(Student student) {
        System.out.println();
        return student;
    }
}
