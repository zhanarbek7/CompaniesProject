package com.zhanarbek.dao.interfaces;

import com.zhanarbek.entities.Group;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface GroupDAO {
    List<Group> getAllGroups();
    void addGroup(Group group);
    Group getGroupById(Long id);
    void updateGroup(Group group);
    void deleteGroup(Group group);
}
