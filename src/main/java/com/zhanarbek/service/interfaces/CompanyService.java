package com.zhanarbek.service.interfaces;

import com.zhanarbek.entities.Company;

import java.util.List;
import java.util.Set;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
public interface CompanyService {
    List<Company> getAllCompanies();
    void addCompany(Company company);
    Company getCompanyById(Long id);
    void updateCompany(Company company);
    void deleteCompany(Company company);

}
