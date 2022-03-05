package com.zhanarbek.controllers;

import com.zhanarbek.entities.Course;
import com.zhanarbek.entities.Group;
import com.zhanarbek.entities.Student;
import com.zhanarbek.service.CompanyService;
import com.zhanarbek.service.CourseService;
import com.zhanarbek.service.GroupService;
import com.zhanarbek.service.GroupsCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final CourseService courseService;
    private final GroupsCoursesService groupCoursesService;
    @Autowired
    public GroupController(CompanyService companyService, GroupService groupService, CourseService courseService, GroupsCoursesService groupCoursesService) {
        this.companyService = companyService;
        this.groupService = groupService;
        this.courseService = courseService;
        this.groupCoursesService = groupCoursesService;
    }

    @GetMapping("/getGroups")
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

    @GetMapping("/addGroup")
    public String addGroup(@RequestParam("companyId") Long id,Model model){
        model.addAttribute("group",new Group());
        model.addAttribute("courses",companyService.getCompanyById(id).getCourses());
        return "groups/addGroup";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@RequestParam("companyId") Long id,
                            @ModelAttribute("group") Group group,
                            @RequestParam(value = "courss" , required = false) String[] sCourses){
        List<Course> lCourses = new ArrayList<>();
        group.setCompany(companyService.getCompanyById(id));
        try{
            for (String sCours : sCourses) {
                lCourses.add(courseService.getCourseById((long) Integer.parseInt(sCours)));
            }
        }
        catch(NullPointerException e){
            System.out.println("It is null!");
        }

        group.setCourses(lCourses);
        groupService.addGroup(group);
        return "redirect:/getGroups?companyId="+id;
    }

    @GetMapping("/getGroupsSelectedThisCourse")
    public String getGroupsSelectedThisCourses(@RequestParam("courseId") Long courseId, @RequestParam("companyId") Long companyId,
                                               Model model){
        List<Group> groups = new ArrayList<>();
        for(int i = 0; i<groupCoursesService.getGroupsSelectedThisCourses(courseId).size();i++){
            groups.add(groupService.getGroupById(groupCoursesService.getGroupsSelectedThisCourses(courseId).get(i)));
        }
        System.out.println(groups);
        model.addAttribute("groups",groups);
        return "groups/groups";
    }

    @GetMapping("/updateGroup")
    public String updateGroup(@RequestParam("groupId") Long groupId ,@RequestParam("companyId") Long companyId,Model model){
        model.addAttribute("group",groupService.getGroupById(groupId));
        model.addAttribute("courses",companyService.getCompanyById(companyId).getCourses());
        return "groups/updateGroup";
    }

    @PutMapping("/saveUpdateGroup")
    public String saveUpdateGroup(@RequestParam("companyId") Long id,
                            @ModelAttribute("group") Group group,
                            @RequestParam(value = "courss" , required = false) String[] sCourses){
        List<Course> lCourses = new ArrayList<>();
        group.setCompany(companyService.getCompanyById(id));
        try{
            for (String sCours : sCourses) {
                lCourses.add(courseService.getCourseById((long) Integer.parseInt(sCours)));
            }
        }
        catch(NullPointerException e){
            System.out.println("Courses selected is null!");
        }

        group.setCourses(lCourses);
        groupService.updateGroup(group);
        return "redirect:/getGroups?companyId="+id;
    }

    @RequestMapping("/deleteGroup")
    public String deleteGroup(@RequestParam("groupId") Long groupId, @RequestParam("companyId") Long companyId){
        groupService.deleteGroup(groupService.getGroupById(groupId));
        return "redirect:/getGroups?companyId="+companyId;
    }

    @GetMapping("/findStudent")
    public String findStudentInGroupsPage(@RequestParam("studentName") String studentName, Model model){
        List<Student> studentsFound = new ArrayList<>();
        for(int i = 0; i<groupService.getAllGroups().size(); i++){
            for(int j =0;j<groupService.getAllGroups().get(i).getStudents().size();j++){
                if((groupService.getAllGroups().get(i).getStudents().get(j).getFirstName()+" "+
                groupService.getAllGroups().get(i).getStudents().get(j).getLastName()).contains(studentName)
                ){
                    studentsFound.add(groupService.getAllGroups().get(i).getStudents().get(j));
                }
            }
        }
        model.addAttribute("students", studentsFound);
        return "numberOfStudents";
    }


}
