package com.zhanarbek.service.classes;

import com.zhanarbek.dao.interfaces.StudentDAO;
import com.zhanarbek.entities.Student;
import com.zhanarbek.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }
}
