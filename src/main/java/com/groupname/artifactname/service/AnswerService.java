package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.Answer;
import com.groupname.artifactname.entity.Content;
import com.groupname.artifactname.entity.Question;
import com.groupname.artifactname.repository.AnswerRepository;
import com.groupname.artifactname.repository.ContentRepository;
import com.groupname.artifactname.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ContentRepository contentRepository;

    public Answer addAnswer(Answer answer, int qId) {
        Question question = questionRepository.findById(qId).get();
        answer.setQuestion(question);
//        question.addAnswer(answer);
//        questionRepository.save(question);
        return answerRepository.save(answer);
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public Answer updateAns(Answer answer, int aId) {
        Answer answerDb = answerRepository.findById(aId).get();
        answerDb.setMarksGet(answer.getMarksGet());
        return answerRepository.save(answerDb);
    }

    public Question getQstOfAns(int aId) {
        return answerRepository.findById(aId).get().getQuestion();
    }

    public void changleContList(Answer answer){
        List<Content> contents = answer.getContents();
        for (Content content : contents){
            Content contentDb = contentRepository.findById(content.getId()).get();
            List<Answer> ansList = contentDb.getAnswers();
            ansList.remove(answer);

            contentDb.setAnswers(ansList);
            contentRepository.save(contentDb);
        }
    }

    public void deleteAns(int aId) {
        Answer answer = answerRepository.findById(aId).get();
        changleContList(answer);
        answer.setContents(null);
        answerRepository.delete(answer);
    }

    public List<Content> getContOfAns(int aId) {
        return answerRepository.findById(aId).get().getContents();
    }
}
