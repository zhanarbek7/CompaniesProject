package com.zhanarbek.service;

import com.zhanarbek.entities.Teacher;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 26/2/22
 */
public interface TeacherService {
    List<Teacher> getAllTeachers();

    void addTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

}
