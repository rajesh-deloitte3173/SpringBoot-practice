package com.groupname.artifactname.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String qst;

    private int marks;

    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public void addAnswer(Answer answer){
        if (answers.isEmpty()){
            answers = new ArrayList<>();
        }
        answers.add(answer);
    }

}
