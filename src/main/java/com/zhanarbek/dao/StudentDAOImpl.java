package com.zhanarbek.dao;

import com.zhanarbek.entities.Student;
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
public class StudentDAOImpl implements StudentDAO{

    //inject dependency
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public List<Student>getAllStudents(){
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
}
