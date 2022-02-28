package com.zhanarbek.dao.classes;

import com.zhanarbek.dao.interfaces.GroupDAO;
import com.zhanarbek.entities.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Repository
public class GroupDAOImpl implements GroupDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllGroups() {
        return null;
    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public Group getGroupById(Long id) {
        return null;
    }

    @Override
    public void updateGroup(Group group) {

    }

    @Override
    public void deleteGroup(Group group) {

    }
}
