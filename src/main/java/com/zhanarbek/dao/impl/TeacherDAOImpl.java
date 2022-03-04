package com.zhanarbek.dao.impl;

import com.zhanarbek.dao.TeacherDAO;
import com.zhanarbek.entities.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Repository
@Transactional
public class TeacherDAOImpl implements TeacherDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = entityManager.createQuery("from Teacher ", Teacher.class).getResultList();
        Comparator<Teacher> comparator = new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return (int) (o1.getId()-o2.getId());
            }
        };
        Collections.sort(teachers, comparator);
        return teachers;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(entityManager.contains(teacher) ? teacher : entityManager.merge(teacher));
    }
}
