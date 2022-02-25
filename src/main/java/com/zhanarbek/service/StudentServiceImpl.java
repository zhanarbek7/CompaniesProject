package com.zhanarbek.service;

import com.zhanarbek.dao.StudentDAO;
import com.zhanarbek.dao.StudentDAOImpl;
import com.zhanarbek.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Component
public class StudentServiceImpl implements StudentService {
    //define dependency
    private StudentDAO studentDao;

    //inject dependency
    @Autowired
    public StudentServiceImpl(@Qualifier("studentDAOImpl") StudentDAO userDao) {
        this.studentDao = userDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}
