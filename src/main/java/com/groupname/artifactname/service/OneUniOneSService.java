package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.OneUniOneF;
import com.groupname.artifactname.entity.OneUniOneS;
import com.groupname.artifactname.repository.OneUniOneSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneUniOneSService {

    @Autowired
    private OneUniOneSRepository oneUniOneSRepository;

    public OneUniOneS addOneUniOne(OneUniOneS oneUniOneS) {
        System.out.println("input data in service: "+oneUniOneS);

        return oneUniOneSRepository.save(oneUniOneS);
    }

    public List<OneUniOneS> getAllOneUniOneF() {
        return oneUniOneSRepository.findAll();
    }

    public OneUniOneF getMappedDataById(int id) {
        return oneUniOneSRepository.findById(id).get().getOneUniOneF();
    }
}
