package com.zhanarbek.controllers;

import com.zhanarbek.dao.StudentDAO;
import com.zhanarbek.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Controller
public class MainController {



    @GetMapping("/")
    public String getMainPage(){
        return "main";
    }
//    public String getCompaniesPage(){
//        return
//    }
}
