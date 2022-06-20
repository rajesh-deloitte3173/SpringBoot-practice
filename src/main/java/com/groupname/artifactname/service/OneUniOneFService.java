package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.OneUniOneF;
import com.groupname.artifactname.entity.OneUniOneS;
import com.groupname.artifactname.repository.OneUniOneFRepository;
import com.groupname.artifactname.repository.OneUniOneSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneUniOneFService {

    @Autowired
    private OneUniOneFRepository oneUniOneFRepository;

    @Autowired
    private OneUniOneSRepository oneUniOneSRepository;

    public OneUniOneF addOneUniOneF(OneUniOneF oneUniOneF, int sId) {
        OneUniOneS oneUniOneS = oneUniOneSRepository.findById(sId).get();
        oneUniOneF.setOneUniOneS(oneUniOneS);
        return oneUniOneFRepository.save(oneUniOneF);
    }

    public List<OneUniOneF> getAllData() {
        return oneUniOneFRepository.findAll();
    }

}
