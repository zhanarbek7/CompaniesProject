package com.zhanarbek.controllers;

import com.zhanarbek.entities.Group;
import com.zhanarbek.entities.Student;
import com.zhanarbek.entities.Teacher;
import com.zhanarbek.service.CourseService;
import com.zhanarbek.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 1/3/22
 */
@Controller
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;
    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @GetMapping("/getTeachers")
    public String getTeachers(@RequestParam("courseId") Long id, Model model){
        List<Teacher> teachers = new ArrayList<>();
        for(Teacher i: teacherService.getAllTeachers()){
            try{
                if(i.getCourse().getId().equals(id)){
                    teachers.add(i);
                }
            }
            catch(NullPointerException e){
                System.out.println("It is null");
            }
        }
        model.addAttribute("teachers", teachers);
        return "teachers/teachers";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teachers/addTeacher";
    }

    @PostMapping("saveTeacher")
    public String saveCourse(@RequestParam("courseId") Long id,@ModelAttribute("teacher") Teacher teacher){
        teacher.setCourse(courseService.getCourseById(id));
        teacherService.addTeacher(teacher);
        return "redirect:/getTeachers?courseId="+id;
    }

    @GetMapping("/updateTeacher")
    public String updateCourse(@RequestParam("courseId") Long coursesId, @RequestParam("teacherId") Long teacherId
            ,Model model){
        Teacher teacher = teacherService.getTeacherById(teacherId);
        model.addAttribute("teacher", teacher);
        return "teachers/updateTeacher";
    }

    @PostMapping("/saveUpdateTeacher")
    public String saveUpdateCourse(@RequestParam("courseId") Long coursesId, @ModelAttribute("teacher") Teacher teacher){
        teacher.setCourse(courseService.getCourseById(coursesId));
        teacherService.updateTeacher(teacher);
        return "redirect:/getTeachers?courseId="+coursesId;
    }

    @RequestMapping("/deleteTeacher")
    public String deleteCourse(@RequestParam("courseId") Long coursesId, @RequestParam("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherService.getTeacherById(teacherId));
        return "redirect:/getTeachers?courseId="+coursesId;
    }

    @GetMapping("/getStudentsOfTeacher")
    public String getStudentsOfTeacher(@RequestParam("teacherId") Long teacherId, Model model){
        List<Student> students = new ArrayList<>();
        List<Group> groups = teacherService.getTeacherById(teacherId).getCourse().getGroups();
        for(Group i: groups){
            students.addAll(i.getStudents());
        }
        model.addAttribute("students",students);
        model.addAttribute("size",students.size());
        return "numberOfStudents";
    }

}
