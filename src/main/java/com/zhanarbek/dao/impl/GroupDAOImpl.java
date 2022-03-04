package com.zhanarbek.dao.impl;

import com.zhanarbek.dao.GroupDAO;
import com.zhanarbek.entities.Group;
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
public class GroupDAOImpl implements GroupDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = entityManager.createQuery("from Group", Group.class).getResultList();
        Comparator<Group> comparator = new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                return (int) (o1.getId()-o2.getId());
            }
        };
        Collections.sort(groups, comparator);
        return groups;
    }

    @Override
    public void addGroup(Group group) {
        entityManager.persist(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public void updateGroup(Group group) {
        entityManager.merge(group);
    }

    @Override
    public void deleteGroup(Group group) {
        entityManager.remove(entityManager.contains(group) ? group : entityManager.merge(group));
    }
}
