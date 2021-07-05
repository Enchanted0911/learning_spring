package com.jun.bao06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
    @Pointcut("execution(* *..bao06.*.doAfter(..))")
    private void myPointCut(){}

    @After("myPointCut()")
    public void myAfter() {
        System.out.println("总是被执行的最终通知");
    }


    /**
     * 切入点表达式 @Pointcut : 用在一个方法上面，这个方法的名称就是切入点表达式的别名。其他通知中，value属性就可以使用这个方法名，代替接入点表达式
     */
    @Before("myPointCut()")
    public void myBefore() {
        System.out.println("前置通知");
    }
}
