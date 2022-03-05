package com.zhanarbek.controllers;

import com.zhanarbek.entities.Company;
import com.zhanarbek.entities.Group;
import com.zhanarbek.entities.Student;
import com.zhanarbek.service.CompanyService;
import com.zhanarbek.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 26/2/22
 */
@Controller
public class CompanyController {

    private final CompanyService companyService;
    private final GroupService groupService;
    @Autowired
    public CompanyController(CompanyService companyService, GroupService groupService) {
        this.companyService = companyService;
        this.groupService = groupService;
    }

    @GetMapping("/getAllCompanies")
    public String getCompaniesPage(Model model){
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies",companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model){
        model.addAttribute("company",new Company());
        return "company/addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.addCompany(company);
        return "redirect:/getAllCompanies";
    }

    @PutMapping("/updateCompany")
    public String updateCompany(@RequestParam("companyId") Long id, Model model){
        Company company =  companyService.getCompanyById(id);
        model.addAttribute("company",company);
        return "company/updateCompany";
    }

    @PutMapping("/saveUpdateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company){
        companyService.updateCompany(company);
        return "redirect:/getAllCompanies";
    }

    @RequestMapping("deleteCompany")
    public String deleteCompany(@RequestParam("companyId") Long id){
        companyService.deleteCompany(companyService.getCompanyById(id));
        return "redirect:/getAllCompanies";
    }

    @GetMapping("/getStudentsOfCompany")
    public String getStudentsOfCompany(@RequestParam("companyId") Long companyId, Model model){
        List<Student> students = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        for(int i = 0; i<groupService.getAllGroups().size();i++){
            if(groupService.getAllGroups().get(i).getCompany().getId().equals(companyId)){
                groups.add(groupService.getAllGroups().get(i));
            }
        }
        for(Group i: groups){
            students.addAll(i.getStudents());
        }
        model.addAttribute("students",students);
        model.addAttribute("size",students.size());
        return "numberOfStudents";
    }

}
