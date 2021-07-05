package com.jun.bao03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
     */

    @Value("vanessa")
    private String name;

    private Integer age;

    @Autowired
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
