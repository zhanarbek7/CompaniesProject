package com.zhanarbek.controllers;

import com.zhanarbek.dao.StudentDAO;
import com.zhanarbek.entities.Student;
import com.zhanarbek.service.StudentService;
import com.zhanarbek.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Controller
public class MainController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @GetMapping("/")
    public String getMainPage(){
        studentService.getAllStudents();
        return "main";
    }
//    public String getCompaniesPage(){
//        return
//    }
}
