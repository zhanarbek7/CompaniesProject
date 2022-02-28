package com.zhanarbek.dao.interfaces;

import com.zhanarbek.entities.Student;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface StudentDAO {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
