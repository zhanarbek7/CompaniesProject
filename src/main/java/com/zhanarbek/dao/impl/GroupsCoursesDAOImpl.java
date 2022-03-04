package com.zhanarbek.dao.impl;

import com.zhanarbek.dao.GroupsCoursesDAO;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 2/3/22
 */
@Repository
@Transactional
public class GroupsCoursesDAOImpl implements GroupsCoursesDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Long> getGroupsSelectedThisCourses(Long id) {
        Query query = (Query) entityManager.createNativeQuery("select groups_id from groups_courses where courses_id = "+ id);
         List<BigInteger>list = query.getResultList();
         List<Long> list2 = new ArrayList<>();
        for (BigInteger bigInteger : list) {
            list2.add(bigInteger.longValue());
        }
         return list2;
    }
}
