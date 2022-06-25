package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.Answer;
import com.groupname.artifactname.entity.Content;
import com.groupname.artifactname.repository.AnswerRepository;
import com.groupname.artifactname.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Content addCont(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getAllCont() {
        return contentRepository.findAll();
    }

    public void addAnsToCont(int aId, int cId) {
        Answer answer = answerRepository.findById(aId).get();
        Content content = contentRepository.findById(cId).get();

        content.addAnstoCont(answer);
        answer.addContToAns(content);

        answerRepository.save(answer);
        contentRepository.save(content);
    }

    public List<Answer> getAnsOfCont(int cId) {
        return contentRepository.findById(cId).get().getAnswers();
    }

    public Content updateCont(Content content, int cId) {
        Content contentDb = contentRepository.findById(cId).get();
        contentDb.setCont(content.getCont());
        return contentRepository.save(contentDb);
    }

    public void deleteCont(int cId) {
        contentRepository.deleteById(cId);
    }
}
