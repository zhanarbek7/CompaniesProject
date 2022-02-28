package com.zhanarbek.dao.classes;

import com.zhanarbek.dao.interfaces.CompanyDAO;
import com.zhanarbek.entities.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 25/2/22
 */
@Repository
@Transactional
public class CompanyDAOImpl implements CompanyDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = entityManager.createQuery("from Company ", Company.class).getResultList();
        Comparator<Company> comparator = new Comparator<Company>() {
            @Override
            public int compare(Company o1, Company o2) {
                return (int) (o1.getId()-o2.getId());
            }
        };
        Collections.sort(companies, comparator); // use the comparator as much as u want
        return companies;
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    @Override
    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company) ? company : entityManager.merge(company));
    }

}
