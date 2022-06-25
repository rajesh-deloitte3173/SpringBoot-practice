package com.groupname.artifactname.service;

import com.groupname.artifactname.Exception.StudentErrorResponse;
import com.groupname.artifactname.Exception.StudentNotFoundException;
import com.groupname.artifactname.entity.Student;
import com.groupname.artifactname.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {

        if (id>10 || id<1){
            throw new StudentNotFoundException("student not found: " + id);
        }
        return studentRepository.findById(id).get();
    }


}
