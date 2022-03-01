package com.zhanarbek.dao.interfaces;

import com.zhanarbek.entities.Company;
import com.zhanarbek.entities.Teacher;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface TeacherDAO {
    List<Teacher> getAllTeachers();
    void addTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
}
