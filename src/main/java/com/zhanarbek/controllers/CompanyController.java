package com.zhanarbek.controllers;

import com.zhanarbek.entities.Company;
import com.zhanarbek.entities.Course;
import com.zhanarbek.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 26/2/22
 */
@Controller
public class CompanyController {

    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAllCompanies")
    public String getCompaniesPage(Model model){
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies",companies);
        return "company/companies";
    }

    @RequestMapping("/addCompany")
    public String addCompany(Model model){
        model.addAttribute("company",new Company());
        return "company/addCompany";
    }
    @RequestMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.addCompany(company);
        return "redirect:/getAllCompanies";
    }

    @RequestMapping("/updateCompany")
    public String updateCompany(@RequestParam("companyId") Long id, Model model){
        Company company =  companyService.getCompanyById(id);
        model.addAttribute("company",company);
        return "company/updateCompany";
    }
    @RequestMapping("/saveUpdateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company){
        companyService.updateCompany(company);
        return "redirect:/getAllCompanies";
    }
    @RequestMapping("deleteCompany")
    public String deleteCompany(@RequestParam("companyId") Long id){
        companyService.deleteCompany(companyService.getCompanyById(id));
        return "redirect:/getAllCompanies";
    }


}
