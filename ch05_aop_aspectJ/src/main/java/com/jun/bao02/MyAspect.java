package com.jun.bao02;

import com.jun.bao02.domain.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
     * 后置通知定义方法要求 :
     *      1. public
     *      2. void
     *      3. 方法有参数  推荐使用Object
     *
     * @AfterReturning : 后置通知
     *      属性 :
     *          1. value 切入点表达式
     *          2. returning 自定义的变量，表示目标方法返回值，自定义变量名必须和通知方法形参值一样
     */
    @AfterReturning(value = "execution(* *..bao02.impl.*.doOther(..))", returning = "res")
    public void myAfterReturning(JoinPoint jp, Object res) {
        System.out.println("后置通知方法定义 : " + jp.getSignature());
        System.out.println("切面功能 : 在目标方法之后输出执行时间" + "  " + new Date() + "  " + res);
        if (res != null) {
            res = "Vanessa Ives";
        }
        System.out.println(res);
    }
    @AfterReturning(value = "execution(* *..bao02.impl.*.doOther2(..))", returning = "res")
    public void myAfterReturning2(Object res) {
        System.out.println("后置方法执行，改变Student前" + "  " + res);
        Student student = (Student) res;
        if (student != null) {
            student.setAge(18);
            student.setName("vanessa");
        }
        System.out.println("后置方法执行，改变Student后" + "  " + res);
    }
}
