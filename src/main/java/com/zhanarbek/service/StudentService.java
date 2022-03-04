package com.zhanarbek.service;

import com.zhanarbek.entities.Student;
import com.zhanarbek.entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface StudentService {
    List<Student> getAllStudents();

    void addStudent(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    void deleteStudent(Student student);

}
