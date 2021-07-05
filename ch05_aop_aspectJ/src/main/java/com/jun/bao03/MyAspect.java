package com.jun.bao03;

import com.jun.bao02.domain.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Wu
 */
@Aspect
@Component("myAspect")
public class MyAspect {
    /**
     * public Object
     * 必须有返回值 推荐用Object
     * 方法有参  ProceedingJoinPoint
     *
     * 环绕通知注解 @Around
     *      属性 value 切入点表达式
     * 特点 :
     *      1. 功能最强的通知
     *      2. 在目标方法的前后都能增加功能
     *      3. 控制目标方法是否被调用执行
     *      4. 修改原来的目标方法执行结果，影响最后的调用结果
     * 环绕通知等同于jdk动态代理
     * @param proceedingJoinPoint 等同于Method
     * @return 不知道能干什么
     */
    @Around("execution(* *..bao03.*.doFirst(..))")
    @SuppressWarnings("all")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String name = "";
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 1) {
            Object arg = args[0];
            name = (String) arg;
        }
        Object result = null;
        // 相当于method.invoke()
        System.out.println("在目标方法之前做点什么");
        if ("vanessa".equals(name)) {
            result = proceedingJoinPoint.proceed();
        }

        System.out.println("在目标方法之后做点什么");
        if (result != null) {
            result = "Ives";
        }
        return result;
    }
}
