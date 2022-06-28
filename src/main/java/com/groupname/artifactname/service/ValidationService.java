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

        List<Validations> validations =  validationRepository.findAll();
        System.out.println("Month: "+validations.get(0).getLocalDate().getMonth());
        System.out.println("getDayOfMonth: "+validations.get(0).getLocalDate().getDayOfMonth());
        System.out.println("getDayOfWeek: "+validations.get(0).getLocalDate().getDayOfWeek());
        System.out.println("getDayOfYear: "+validations.get(0).getLocalDate().getDayOfYear());
        System.out.println("getMonthValue: "+validations.get(0).getLocalDate().getMonthValue());
        System.out.println("year: "+validations.get(0).getLocalDate().getYear());

        System.out.println("Hour: "+validations.get(0).getLocalTime().getHour());
        System.out.println("Min: "+validations.get(0).getLocalTime().getMinute());
        System.out.println("sec: "+validations.get(0).getLocalTime().getSecond());
        System.out.println("Nano: "+validations.get(0).getLocalTime().getNano());
        return validations;
    }
}
