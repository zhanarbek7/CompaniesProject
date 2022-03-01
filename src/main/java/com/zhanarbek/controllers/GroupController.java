package com.zhanarbek.controllers;

import com.zhanarbek.entities.Group;
import com.zhanarbek.service.interfaces.CompanyService;
import com.zhanarbek.service.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 27/2/22
 */
@Controller
public class GroupController {
    private final CompanyService companyService;
    private final GroupService groupService;
    @Autowired
    public GroupController(CompanyService companyService, GroupService groupService) {
        this.companyService = companyService;
        this.groupService = groupService;
    }

    @RequestMapping("/getGroups")
    public String getAllGroups(@RequestParam("companyId") Long id, Model model){
        List<Group> groups = new ArrayList<>();
        for(Group i: groupService.getAllGroups()){
            try{
                if(i.getCompany().getId().equals(id)){
                    groups.add(i);
                }
            }
            catch(NullPointerException e){
                System.out.println("It is null");
            }

        }
        model.addAttribute("groups", groups);
        return "groups/groups";
    }
    @RequestMapping("/addGroup")
    public String addGroup(@RequestParam("companyId") Long id,Model model){
        model.addAttribute("group",new Group());
        model.addAttribute(companyService.getCompanyById(id).getCourses());
        return "groups/addGroup";
    }
    @RequestMapping("/saveGroup")
    public String saveGroup(@RequestParam("companyId") Long id,
                            @ModelAttribute("group") Group group){
        group.setCompany(companyService.getCompanyById(id));
        groupService.addGroup(group);
        return "redirect:/getGroups?companyId="+id;
    }

}
