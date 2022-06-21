package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.Employ;
import com.groupname.artifactname.entity.Project;
import com.groupname.artifactname.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @CrossOrigin
    @PostMapping
    private Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    @CrossOrigin
    @GetMapping
    private List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @CrossOrigin
    @PutMapping("/{pId}/{eId}")
    private Project addEmployToProject(@PathVariable("pId") int pId, @PathVariable("eId") int eId){
        return projectService.addEmployToProject(pId,eId);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private List<Employ> getProjectEmployes(@PathVariable("id") int pId){
        return projectService.getProjectEmployes(pId);
    }
}
