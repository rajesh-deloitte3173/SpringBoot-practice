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
public class OneUniOneF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "one_one_s_id")
    private OneUniOneS oneUniOneS;
}
