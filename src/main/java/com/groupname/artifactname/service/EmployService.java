package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.Company;
import com.groupname.artifactname.entity.Employ;
import com.groupname.artifactname.repository.CompanyRepository;
import com.groupname.artifactname.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {

    @Autowired
    private EmployRepository employRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Employ addEmploy(Employ employ, int cId) {
        Company company = companyRepository.findById(cId).get();
        employ.setCompany(company);

        return employRepository.save(employ);
    }

    public List<Employ> getAllEmployes() {
        return employRepository.findAll();
    }
}
