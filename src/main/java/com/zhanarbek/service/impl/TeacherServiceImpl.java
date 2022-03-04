package com.zhanarbek.service.impl;

import com.zhanarbek.dao.TeacherDAO;
import com.zhanarbek.entities.Teacher;
import com.zhanarbek.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 26/2/22
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDAO teacherDAO;

    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDAO.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDAO.getTeacherById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDAO.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDAO.deleteTeacher(teacher);
    }
}
