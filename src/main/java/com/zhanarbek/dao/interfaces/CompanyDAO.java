package com.zhanarbek.dao.interfaces;

import com.zhanarbek.entities.Company;

import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface CompanyDAO {
    List<Company> getAllCompanies();
    void addCompany(Company company);
    Company getCompanyById(Long id);
    void updateCompany(Company company);
    void deleteCompany(Company company);
}
