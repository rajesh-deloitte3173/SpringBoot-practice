package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.Answer;
import com.groupname.artifactname.entity.Content;
import com.groupname.artifactname.entity.Question;
import com.groupname.artifactname.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @CrossOrigin
    @PostMapping("/{id}")
    private Answer addAnswer(@RequestBody Answer answer, @PathVariable("id") int qId){
        return answerService.addAnswer(answer, qId);
    }

    @CrossOrigin
    @GetMapping
    private List<Answer> getAllAnswers(){
        return answerService.getAllAnswers();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    private Answer updateAns(@RequestBody Answer answer, @PathVariable("id") int aId){
        return answerService.updateAns(answer,aId);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private Question getQstOfAns(@PathVariable("id") int aId){
        return answerService.getQstOfAns(aId);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    private void deleteAns(@PathVariable("id") int aId){
        answerService.deleteAns(aId);
    }

    @GetMapping("/content/{aId}")
    private List<Content> getContentOfAns(@PathVariable("aId") int aId){
        return answerService.getContOfAns(aId);
    }
}
