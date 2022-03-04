package com.zhanarbek.dao;

import java.math.BigInteger;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 2/3/22
 */
public interface GroupsCoursesDAO {
    List<Long> getGroupsSelectedThisCourses(Long id);
}
