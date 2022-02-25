package com.zhanarbek.dao;

import com.zhanarbek.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    @Transactional
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public List<Student>getAllStudents(){
        entityManager.persist(new Student());
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
}
