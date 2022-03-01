package com.zhanarbek.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(mappedBy = "groups")
    private List<Course> courses;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @ManyToOne
    private Company company;

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(String dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
