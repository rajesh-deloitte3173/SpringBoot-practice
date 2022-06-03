package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.Guardian;
import com.groupname.artifactname.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .studentName("Rajesh")
                .emailId("mail@email.com")
//                .gardianName("RAN")
                .mobileNumber(Long.valueOf("9640432623"))
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("ambufa")
                .number(Long.valueOf("9898989898"))
                .email("ambufa@mail.com")
                .build();

        Student student = Student.builder()
                .studentName("ambu")
                .emailId("ambu@mail.com")
                .mobileNumber(Long.valueOf("9898989898"))
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("All Students :" + studentList);
    }

    @Test
    public void findByName(){
        List<Student> student = studentRepository.findByStudentName("Rajesh");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmail(){
        Student student = studentRepository.getStudentByEmailAddress("ambu@mail.com");
        System.out.println("Student is "+ student);
    }

    @Test
    public void printStudentsByEmailNative(){
        List<Student> students = studentRepository.getStudentByEmailAddressNative("mail@email.com");
        System.out.println("students are" + students);
    }

    @Test
    public void updateStudentName(){
        int i = studentRepository.updateStudentNameByEmail("Ambu", "ambu@mail.com");
        System.out.println("updated:" + i);
    }
}