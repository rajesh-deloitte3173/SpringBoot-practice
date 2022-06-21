package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.Company;
import com.groupname.artifactname.entity.Employ;
import com.groupname.artifactname.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @CrossOrigin
    @PostMapping
    private Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @CrossOrigin
    @GetMapping
    private List<Company> getAllCopanies(){
        return companyService.getAllCompanies();
    }

    @CrossOrigin
    @GetMapping("/{id}/employes")
    private List<Employ> getEmployesOfCompany(@PathVariable("id") int cId){
        return companyService.getEmployesOfCompany(cId);
    }
}
