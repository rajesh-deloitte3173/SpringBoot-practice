package com.groupname.artifactname.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OneUniOneS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    @JsonIgnore
    @OneToOne(mappedBy = "oneUniOneS")
    private OneUniOneF oneUniOneF;
}
