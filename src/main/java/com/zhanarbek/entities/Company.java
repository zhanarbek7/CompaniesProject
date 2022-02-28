package com.zhanarbek.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Entity
@Table(name = "companies")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;

    @OneToMany(fetch=FetchType.EAGER ,cascade = {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "company")
    private List<Course> courses;

    public Company() {
    }
    @OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
    private List<Group> groups;

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocatedCountry() {
        return locatedCountry;
    }

    public void setLocatedCountry(String locatedCountry) {
        this.locatedCountry = locatedCountry;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCountry='" + locatedCountry + '\'' +
                ", courses=" + courses +
                '}';
    }
}
