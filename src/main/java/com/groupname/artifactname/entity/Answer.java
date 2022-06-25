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
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ans;

    private int marksGet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonIgnore
    @ManyToMany(mappedBy = "answers")
    private List<Content> contents = new ArrayList<>();

    public void addContToAns(Content content){
        contents.add(content);
    }
}
