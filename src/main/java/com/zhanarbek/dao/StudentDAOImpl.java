package com.zhanarbek.dao;

import com.zhanarbek.configs.HibernateConfig;
import com.zhanarbek.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Repository
public class StudentDAOImpl implements StudentDAO{

    //inject dependency

    @Override
    @Transactional
    public List<Student>getAllStudents(){
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(new Student("Zhanarbek","Abdurasulov"));
        List<Student> students = session.createQuery("from Student ", Student.class).getResultList();
        return students;
    }
}
