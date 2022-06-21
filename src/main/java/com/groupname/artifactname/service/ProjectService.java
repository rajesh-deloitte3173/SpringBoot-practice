package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.Employ;
import com.groupname.artifactname.entity.Project;
import com.groupname.artifactname.repository.EmployRepository;
import com.groupname.artifactname.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployRepository employRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project addEmployToProject(int pId, int eId) {
        Project project = projectRepository.findById(pId).get();
        Employ employ = employRepository.findById(eId).get();
        employ.addProject(project);
        project.addEmploy(employ);
        return projectRepository.save(project);
    }

    public List<Employ> getProjectEmployes(int pId) {
        return projectRepository.findById(pId).get().getEmploys();
    }
}
