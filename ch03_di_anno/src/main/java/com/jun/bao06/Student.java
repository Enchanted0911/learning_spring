package com.jun.bao06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Wu
 * 注意 : 注解中只有value属性的时候可以省略value @Component("myStudent")
 *还可以由spring提供默认的对象id 类名的首字母小写   @Component
 * 其他对象注解  @Repository 持久层注解  @Service 业务层注解  @controller ？？？注解 忘记了
 */

@Component(value = "myStudent")
public class Student {
    /*
        简单类型的属性赋值
        属性value 是 String类型的，表示简单类型的属性值
        位置
            1. 在属性定义上面，无需set方法 推荐使用
            2. 在set方法上面

        引用类型
        spring框架提供 @Autowired 使用自动注入原理  默认byType
        @Autowired 有属性 required 默认为true 表示自动注入失败程序报错并中止执行
                         required为false 表示自动注入失败，程序正常执行，引用类型为null
        如果要使用byName, 需要做的是 :
            1. 在属性上面加入@Autowired
            2. 在属性上面加入@Qualifier(value = "bean的id")



        @Resource : 来自jdk中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
                    使用的也是自动注入原理，支持byName byType 默认 byName 如果byName失败会自动用byType
                    如果只使用byName则需要给注解的name属性赋值 @Resource(name = "mySchool")
                    使用位置同@Autowired
     */

    @Value("${myName}")
    private String name;

    private Integer age;

    @Resource
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    @Value("18")
    public void setAge(Integer age) {
        this.age = age;
    }
}
