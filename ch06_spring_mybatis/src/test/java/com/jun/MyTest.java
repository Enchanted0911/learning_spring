package com.jun;

import com.jun.dao.StudentDao;
import com.jun.domain.Student;
import com.jun.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
    }

    @Test
    public void test02() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) applicationContext.getBean("studentDao");
        int num = dao.insertStudent(new Student(1007, "fiona", "fiona@ch.com", 28));
        System.out.println(num == 1 ? "success" : "filed");
    }

    @Test
    public void test03() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        int num = studentService.addStudent(new Student(1008, "debee", "debee@en.com", 12));
        // spring 和 mybatis整合时，事务是自动提交的，无需SqlSession.commit()
        System.out.println(num == 1 ? "success" : "filed");
    }

    @Test
    public void test04() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        List<Student> list = studentService.queryStudents();
        // spring 和 mybatis整合时，事务是自动提交的，无需SqlSession.commit()
        list.forEach(System.out::println);
    }
}
