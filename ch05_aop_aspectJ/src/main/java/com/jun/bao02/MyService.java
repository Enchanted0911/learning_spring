package com.jun.bao02;

import com.jun.bao02.domain.Student;

/**
 * @author Wu
 */
public interface MyService {
    /**
     * 不知道该干点什么
     * @param name 不知道有什么用
     * @param age 同上
     */
    void doSome(String name, Integer age);

    /**
     * 普通的
     * @return 没什么
     */
    String doOther();

    /**
     * 测试一下引用类型能否被改变
     * @param student 测试学生
     * @return 代理后的学生
     */
    Student doOther2(Student student);
}
