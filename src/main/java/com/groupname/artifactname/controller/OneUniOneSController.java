package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.OneUniOneF;
import com.groupname.artifactname.entity.OneUniOneS;
import com.groupname.artifactname.service.OneUniOneSService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/onetoones")
public class OneUniOneSController {

    @Autowired
    private OneUniOneSService oneUniOneSService;

    @CrossOrigin
    @PostMapping
    private OneUniOneS addOneUniOne(@RequestBody OneUniOneS oneUniOneS){
        System.out.println("input data is: " +oneUniOneS);

        return oneUniOneSService.addOneUniOne(oneUniOneS);
    }

    @CrossOrigin
    @GetMapping
    private List<OneUniOneS> getAllData(){
       return oneUniOneSService.getAllOneUniOneF();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private OneUniOneF getMappedDataById(@PathVariable("id") int id){
        return oneUniOneSService.getMappedDataById(id);
    }
}
