package com.zhanarbek;

import com.zhanarbek.configs.HibernateConfig;
import com.zhanarbek.dao.StudentDAO;
import com.zhanarbek.dao.StudentDAOImpl;
import com.zhanarbek.service.StudentService;
import com.zhanarbek.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public class App {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl(new StudentDAOImpl());
        studentService.getAllStudents();
    }
}
