package com.jun.handler;

import com.jun.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Wu
 */
@SuppressWarnings("all")
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        ServiceTools.doLog();
        result = method.invoke(target, args);
        ServiceTools.doWhat();
        return result;
    }
}
