package com.jun.bao01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Wu
 */
@Aspect
public class MyAspect {
    /**
     * 定义方法要求 :
     *      1. public
     *      2. void
     *      3. 方法可以有参数也可以无参数
     *      4. 如果有参数, 参数不是自定义的, 有几个参数类型可以使用
     *
     * 指定通知方法中的参数 : JoinPoint
     * JoinPoint 业务方法
     *      作用 : 在通知方法中获取业务方法执行时的信息，例如方法名称，方法实参。
     *      这个JoinPoint参数的值是由框架赋予，必须是第一个位置的参数
     */
    @Before("execution(* com.jun.bao01.impl.*.*(..))")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("方法的签命(定义) = " + joinPoint.getSignature());
        System.out.println("方法的名称 = " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(System.out::println);
        System.out.println("切面功能 : 在目标方法之前输出执行时间" + "  " + new Date());
    }
}
