package com.zhanarbek.controllers;

import com.zhanarbek.entities.Student;
import com.zhanarbek.service.GroupService;
import com.zhanarbek.service.StudentService;
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
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/getStudents")
    public String getStudents(@RequestParam("groupId") Long groupId, Model model){
        List<Student> students = new ArrayList<>();
        for(int i = 0 ; i<studentService.getAllStudents().size();i++){
            try {
                if (studentService.getAllStudents().get(i).getGroup().getId().equals(groupId)) {
                    students.add(studentService.getAllStudents().get(i));
                }
            }
            catch(NullPointerException e){
                System.out.println("It is null");
            }
        }
        model.addAttribute("students",students);
        return "students/students";
    }

    @GetMapping("/addStudent")
    public String addStudent(@RequestParam("groupId") Long groupId, Model model){
        model.addAttribute("student", new Student());
        return "students/addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestParam("groupId") Long groupId,@ModelAttribute("student") Student student){
        student.setGroup(groupService.getGroupById(groupId));
        studentService.addStudent(student);
        return "redirect:/getStudents?groupId="+groupId;
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") Long studentId, @RequestParam("groupId") Long groupId, Model model){
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student",student );
        return "students/updateStudents";
    }
    @PostMapping("/saveUpdateStudent")
    public String saveUpdateStudent(@RequestParam("groupId") Long groupId, @ModelAttribute("student") Student student){
        student.setGroup(groupService.getGroupById(groupId));
        studentService.updateStudent(student);
        return "redirect:/getStudents?groupId="+groupId;
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long studentId, @RequestParam("groupId") Long groupId){
        System.out.println("Hello world");
        studentService.deleteStudent(studentService.getStudentById(studentId));
        return "redirect:/getStudents?groupId="+groupId;
    }

}
