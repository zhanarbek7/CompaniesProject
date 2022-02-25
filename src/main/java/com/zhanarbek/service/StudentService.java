package com.zhanarbek.service;

import com.zhanarbek.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface StudentService {
    List<Student> getAllStudents();

}
