package com.groupname.artifactname.controller;

import com.groupname.artifactname.Exception.StudentErrorResponse;
import com.groupname.artifactname.Exception.StudentNotFoundException;
import com.groupname.artifactname.entity.Student;
import com.groupname.artifactname.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studnet")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    private Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    private Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exe.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }
}
