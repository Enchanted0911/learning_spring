package com.jun.controller;

import com.jun.domain.Student;
import com.jun.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wu
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");

        // String config = "applicationContext.xml";
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        // StudentService studentService = (StudentService) applicationContext.getBean("studentService");
//        WebApplicationContext webApplicationContext = null;
//        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        Object attr = getServletContext().getAttribute(key);
//        if (attr != null) {
//            webApplicationContext = (WebApplicationContext) attr;
//        }
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        StudentService studentService = (StudentService) webApplicationContext.getBean("studentService");
        Student student = new Student(Integer.parseInt(strId), strName, strEmail, Integer.parseInt(strAge));
        studentService.addStudent(student);
        System.out.println(webApplicationContext);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
