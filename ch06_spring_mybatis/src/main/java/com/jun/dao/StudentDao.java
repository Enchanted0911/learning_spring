package com.jun.dao;

import com.jun.domain.Student;

import java.util.List;

/**
 * @author Wu
 */
public interface StudentDao {
    /**
     * 添加一个学生
     * @param student 被添加的学生
     * @return 结果
     */
    int insertStudent(Student student);

    /**
     * 查询学生集
     * @return 学生集
     */
    List<Student> selectStudents();
}
