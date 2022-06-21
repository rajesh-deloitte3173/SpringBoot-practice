package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.Employ;
import com.groupname.artifactname.entity.Project;
import com.groupname.artifactname.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/employ")
public class EmployController {

    @Autowired
    private EmployService employService;

    @CrossOrigin
    @PostMapping("/{id}")
    private Employ addEmploy(@RequestBody Employ employ, @PathVariable("id") int cId){
        return employService.addEmploy(employ, cId);
    }

    @CrossOrigin
    @GetMapping
    private List<Employ> getAllEmployes(){
        return employService.getAllEmployes();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private List<Project> getEmployProjects(@PathVariable("id") int eId){
        return employService.getEmployProjects(eId);
    }
}
