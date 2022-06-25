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
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cont;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "content_answer",
            joinColumns = {@JoinColumn(name = "content_id")},
            inverseJoinColumns = {@JoinColumn(name = "answer_id")}
    )
    private List<Answer> answers = new ArrayList<>();

    public void addAnstoCont(Answer answer){
        answers.add(answer);
    }
}
