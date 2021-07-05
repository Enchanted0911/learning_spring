package com.jun.service.impl;

import com.jun.dao.StudentDao;
import com.jun.domain.Student;
import com.jun.service.StudentService;

import java.util.List;

/**
 * @author Wu
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudents() {
        return studentDao.selectStudents();
    }
}
