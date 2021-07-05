package com.jun.bao02.impl;

import com.jun.bao02.MyService;

/**
 * @author Wu
 */
public class MyServiceImpl implements MyService {
    @Override
    public void doSome() {
        System.out.println("执行了接口实现类的方法");
    }
}
