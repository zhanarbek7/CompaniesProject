package com.zhanarbek.service.interfaces;

import com.zhanarbek.entities.Group;

import java.util.List;
import java.util.Set;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 26/2/22
 */
public interface GroupService {
    List<Group> getAllGroups();
    void addGroup(Group group);
    Group getGroupById(Long id);
    void updateGroup(Group group);
    void deleteGroup(Group group);
}
