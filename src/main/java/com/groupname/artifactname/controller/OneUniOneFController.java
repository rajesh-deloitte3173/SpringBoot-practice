package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.OneUniOneF;
import com.groupname.artifactname.entity.OneUniOneS;
import com.groupname.artifactname.service.OneUniOneFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/onetoonef")
public class OneUniOneFController {

    @Autowired
    private OneUniOneFService oneUniOneFService;

    @CrossOrigin
    @PostMapping("/{id}")
    private OneUniOneF addOneUniOneF(@RequestBody OneUniOneF oneUniOneF, @PathVariable("id") int sId){
        return oneUniOneFService.addOneUniOneF(oneUniOneF, sId);
    }

    @CrossOrigin
    @GetMapping
    private List<OneUniOneF> getAllData(){
        return oneUniOneFService.getAllData();
    }

}
