package com.zhanarbek.controllers;

import com.zhanarbek.entities.Company;
import com.zhanarbek.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

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
}
