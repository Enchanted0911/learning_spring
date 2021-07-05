package com.jun.bao02.impl;

import com.jun.bao02.MyService;

/**
 * @author Wu
 */
public class MyServiceImpl implements MyService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");
    }

    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther");
    }
}
