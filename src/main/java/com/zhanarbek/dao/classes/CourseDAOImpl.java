package com.zhanarbek.dao.classes;

import com.zhanarbek.dao.interfaces.CourseDAO;
import com.zhanarbek.entities.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void deleteCourse(Course course) {
        entityManager.remove(entityManager.contains(course) ? course : entityManager.merge(course));
    }
}
