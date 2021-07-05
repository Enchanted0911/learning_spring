package com.jun.bao04;

import org.aspectj.lang.annotation.AfterThrowing;
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
     * 方法可以无参  如果有参是JoinPoint或者Exception
     *
     * 异常通知注解 @AfterThrowing
     *      属性 value 切入点表达式
     *          throwing 自定义变量，表示目标方法抛出的异常对象，变量名必须和方法参数名一致
     * 类似catch
     */
    @AfterThrowing(value = "execution(* *..bao04.*.doException(..))", throwing = "exception")
    public void myAfterThrowing(Exception exception) {
        System.out.println("异常发生时通知");
    }
}
