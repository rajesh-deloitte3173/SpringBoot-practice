package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.Company;
import com.groupname.artifactname.entity.Employ;
import com.groupname.artifactname.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Employ> getEmployesOfCompany(int cId) {
        Company company = companyRepository.findById(cId).get();
        return company.getEmploys();
    }
}
