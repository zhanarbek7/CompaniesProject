package com.zhanarbek.dao;

import com.zhanarbek.entities.Company;
import com.zhanarbek.entities.Course;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface CourseDAO {
    void addCourse(Course course);

    Course getCourseById(Long id);

    void updateCourse(Course course);

    void deleteCourse(Course course);
}
