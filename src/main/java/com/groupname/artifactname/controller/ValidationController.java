package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.Validations;
import com.groupname.artifactname.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @PostMapping
    private Validations addValidations(@Valid @RequestBody Validations validations){
        return validationService.addValidations(validations);
    }

    @GetMapping
    private List<Validations> getValidations(){
        return validationService.getValidations();
    }
}
