package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.CurdPractice;
import com.groupname.artifactname.repository.CurdPracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurdPracticeService {

    @Autowired
    private CurdPracticeRepository curdPracticeRepository;

    public CurdPractice addItem(CurdPractice curdPractice) {

        return curdPracticeRepository.save(curdPractice);
    }

    public List<CurdPractice> getAllItems() {
        return curdPracticeRepository.findAll();
    }

    public void deleteItem(int iId) {

        CurdPractice curdPractice = curdPracticeRepository.findById(iId).get();
        curdPracticeRepository.delete(curdPractice);
    }

    public void deleteItembId(int iId) {
        curdPracticeRepository.deleteById(iId);
    }

    public CurdPractice updateItem(CurdPractice curdPractice, int iId) {

        CurdPractice curdPracticeDb = curdPracticeRepository.findById(iId).get();

//        curdPractice.setId(curdPracticeDb.getId());
        curdPracticeDb.setName(curdPractice.getName());
        curdPracticeDb.setLast(curdPractice.getLast());

        return curdPracticeRepository.save(curdPracticeDb);
    }
}
