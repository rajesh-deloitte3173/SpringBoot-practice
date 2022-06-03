package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByStudentName(String studentName);
    List<Student> findByStudentNameContaining(String Name);
    List<Student> findByMobileNumberNotNull();
    List<Student> findByGuardianName(String guardianName);

//    JPQL :- based on classes we created not on tables
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

//    Native Query :- Based on tables in DB
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_add = ?1",
            nativeQuery = true
    )
    List<Student> getStudentByEmailAddressNative(String emailId);

//    native quary named param
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_add = :emailId",
            nativeQuery = true
    )
    List<Student> getStudentByEmailAddressNativeByNamedParam(
            @Param("emailId") String emailId
    );

//    updating
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set student_name = ?1 where email_add = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmail(String studentName, String emailId);
}
