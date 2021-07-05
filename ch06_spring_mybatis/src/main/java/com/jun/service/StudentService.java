package com.jun.service;

import com.jun.domain.Student;

import java.util.List;

/**
 * @author Wu
 */
public interface StudentService {
    /**
     * 添加学生
     * @param student 添加的学生
     * @return 添加结果
     */
    int addStudent(Student student);

    /**
     * 查询学生集
     * @return 学生集合
     */
    List<Student> queryStudents();
}
