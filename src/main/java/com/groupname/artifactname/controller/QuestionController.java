package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.Answer;
import com.groupname.artifactname.entity.Question;
import com.groupname.artifactname.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    private Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @CrossOrigin
    @GetMapping
    private List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    private Question updateQuestion(@RequestBody Question question, @PathVariable("id") int qId){
        return questionService.updateQuestion(question, qId);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private List<Answer> getAnsOfQst(@PathVariable("id") int qId){
        return questionService.getAnsOfQst(qId);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    private void deleteQst(@PathVariable("id") int qId){
        questionService.deleteQst(qId);
    }
}
