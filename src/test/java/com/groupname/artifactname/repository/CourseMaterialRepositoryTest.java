package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.Course;
import com.groupname.artifactname.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course =
                Course.builder()
                        .title("python")
                        .credits(2)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.email.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void findAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println(courseMaterials);
    }

}