package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.Answer;
import com.groupname.artifactname.entity.Question;
import com.groupname.artifactname.repository.AnswerRepository;
import com.groupname.artifactname.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerService answerService;

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question updateQuestion(Question question, int qId) {
        Question questionDb = questionRepository.findById(qId).get();
        questionDb.setMarks(question.getMarks());
        return questionRepository.save(questionDb);
    }

    public List<Answer> getAnsOfQst(int qId) {
        return questionRepository.findById(qId).get().getAnswers();
    }

    public void deleteQst(int qId) {
        Question question = questionRepository.findById(qId).get();
        List<Answer> answers = question.getAnswers();
        for (Answer answer : answers){
            answerService.changleContList(answer);
        }
        questionRepository.deleteById(qId);
    }
}
