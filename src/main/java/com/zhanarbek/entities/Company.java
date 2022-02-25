package com.zhanarbek.entities;

import javax.persistence.*;

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

    public Company() {
    }

}
