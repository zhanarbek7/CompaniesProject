package com.zhanarbek.service.classes;

import com.zhanarbek.dao.interfaces.CompanyDAO;
import com.zhanarbek.entities.Company;
import com.zhanarbek.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;
    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    @Override
    public void addCompany(Company company) {
        companyDAO.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDAO.getCompanyById(id);
    }

    @Override
    public void updateCompany(Company company) {
        companyDAO.updateCompany(company);
    }

    @Override
    public void deleteCompany(Company company) {
        companyDAO.deleteCompany(company);
    }
}
