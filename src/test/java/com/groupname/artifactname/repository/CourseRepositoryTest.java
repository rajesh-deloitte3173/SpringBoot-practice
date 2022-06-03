package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.Course;
import com.groupname.artifactname.entity.Student;
import com.groupname.artifactname.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void allCourses(){
        List<Course> courses =
                courseRepository.findAll();

        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher
                .builder()
                .teacherName("mani")
                .build();

        Course course = Course
                .builder()
                .title(".net")
                .credits(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

//    Pagination
    @Test
    public void findAllPagination(){
        Pageable fistpageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("courses" + courses);
        System.out.println("total Elements" + totalElements);
        System.out.println("Total Pages" + totalPages);
    }

//    pagination with sorting
    @Test
    public void paginationWithSorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );

        Pageable sortByCreditsInDesc = PageRequest.of(
                0,
                2,
                Sort.by("credits").descending()
        );

        Pageable sortByTiTleAndCredits = PageRequest.of(
                0,
                2,
                Sort.by("title").descending()
                        .and(Sort.by("credits"))
        );

        List<Course> courses = courseRepository.findAll(sortByTiTleAndCredits).getContent();

        System.out.println("courses "+ courses);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstThreeRecords = PageRequest.of(0,3);

        List<Course> courses = courseRepository.findByTitleContaining("j", firstThreeRecords).getContent();

        System.out.println("courses "+ courses);
    }

    @Test
    public void saveCoursewithStudentAndTeacher(){

        Teacher teacher = Teacher
                .builder()
                .teacherName("Roy")
                .build();

        Student student = Student
                .builder()
                .studentName("buchi")
                .mobileNumber(Long.valueOf("9876543210"))
                .emailId("buchi@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credits(20)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);


    }

}