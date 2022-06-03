package com.groupname.artifactname.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequience",
            sequenceName = "teacher_sequience",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequience"
    )
    private Long teacherId;
    private String teacherName;

//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> courses;
}
