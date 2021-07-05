package com.jun;

import com.jun.handler.MyInvocationHandler;
import com.jun.bao02.MyService;
import com.jun.bao02.impl.MyServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test01 {
    @Test
    public void Test1() {
        MyService target = new MyServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(target);
        MyService proxy = (MyService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.doSome();
    }
}
