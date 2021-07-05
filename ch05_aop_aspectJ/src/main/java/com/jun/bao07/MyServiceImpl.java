package com.jun.bao07;

import org.springframework.stereotype.Component;

/**
 * @author Wu
 */
@Component("myService")
public class MyServiceImpl {
    public void doSome(String name, Integer age) {
        System.out.println("不知道该干点什么");
    }
}
