package com.zhanarbek.service.interfaces;

import com.zhanarbek.entities.Course;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 26/2/22
 */
public interface CourseService {
    void addCourse(Course course);
    Course getCourseById(Long id);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}
