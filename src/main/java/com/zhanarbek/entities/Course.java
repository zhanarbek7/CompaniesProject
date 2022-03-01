package com.zhanarbek.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Entity
@Table(name = "courses")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_in_month")
    private String durationInMonth;

    @ManyToOne
    private Company company;

    @ManyToMany
    private List<Group> groups;

    @OneToOne(mappedBy = "course")
    private Teacher teacher;

    public Course(String courseName, String durationInMonth) {
        this.courseName = courseName;
        this.durationInMonth = durationInMonth;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDurationInMonth() {
        return durationInMonth;
    }

    public void setDurationInMonth(String durationInMonth) {
        this.durationInMonth = durationInMonth;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



}
