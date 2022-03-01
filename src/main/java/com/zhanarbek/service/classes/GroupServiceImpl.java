package com.zhanarbek.service.classes;

import com.zhanarbek.dao.interfaces.GroupDAO;
import com.zhanarbek.entities.Group;
import com.zhanarbek.service.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 26/2/22
 */
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDAO groupDAO;
    @Autowired
    public GroupServiceImpl(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.getAllGroups();
    }

    @Override
    public void addGroup(Group group) {
        groupDAO.addGroup(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDAO.getGroupById(id);
    }

    @Override
    public void updateGroup(Group group) {
        groupDAO.updateGroup(group);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDAO.deleteGroup(group);
    }
}
