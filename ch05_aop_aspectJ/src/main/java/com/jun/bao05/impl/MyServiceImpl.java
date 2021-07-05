package com.jun.bao05.impl;

import com.jun.bao02.domain.Student;
import com.jun.bao05.MyService;
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

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("==========doFirst===========");
        return "vanessa";
    }

    @Override
    public void doException() {
        System.out.println("来创造一个异常" + (10 / 0));
    }

    @Override
    public void doAfter() {
        System.out.println("最终通知的业务方法");
    }
}
