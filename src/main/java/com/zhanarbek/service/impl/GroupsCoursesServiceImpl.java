package com.zhanarbek.service.impl;

import com.zhanarbek.dao.GroupsCoursesDAO;
import com.zhanarbek.service.GroupsCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 2/3/22
 */
@Service
public class GroupsCoursesServiceImpl implements GroupsCoursesService {
    private final GroupsCoursesDAO groupsCoursesDAO;
    @Autowired
    public GroupsCoursesServiceImpl(GroupsCoursesDAO groupsCoursesDAO) {
        this.groupsCoursesDAO = groupsCoursesDAO;
    }

    @Override
    public List<Long> getGroupsSelectedThisCourses(Long id) {
        return groupsCoursesDAO.getGroupsSelectedThisCourses(id);
    }
}
