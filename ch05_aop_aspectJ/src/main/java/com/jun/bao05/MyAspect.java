package com.jun.bao05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Wu
 */
@Aspect
@Component("myAspect")
public class MyAspect {
    /**
     * public void
     * 方法可以无参  如果有参是JoinPoint
     *
     * 最终通知注解 @After
     *      属性 value 切入点表达式
     * 特点 :
     *      1. 总是会执行 类似finally ?
     *      2. 目标方法之后执行
     */
    @After("execution(* *..bao05.*.doAfter(..))")
    public void myAfter() {
        System.out.println("总是被执行的最终通知");
    }
}
