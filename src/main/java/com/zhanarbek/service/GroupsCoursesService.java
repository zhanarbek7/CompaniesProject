package com.zhanarbek.service;

import java.math.BigInteger;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 2/3/22
 */
public interface GroupsCoursesService {

    List<Long> getGroupsSelectedThisCourses(Long id);
}
