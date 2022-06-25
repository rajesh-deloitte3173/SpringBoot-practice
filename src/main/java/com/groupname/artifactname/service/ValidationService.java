package com.groupname.artifactname.service;

import com.groupname.artifactname.entity.Validations;
import com.groupname.artifactname.repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {

    @Autowired
    private ValidationRepository validationRepository;

    public Validations addValidations(Validations validations) {
        return validationRepository.save(validations);
    }

    public List<Validations> getValidations() {
        return validationRepository.findAll();
    }
}
