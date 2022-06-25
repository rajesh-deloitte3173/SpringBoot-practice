package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.CurdPractice;
import com.groupname.artifactname.service.CurdPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/curd")
public class CurdPracticeController {

    @Autowired
    private CurdPracticeService curdPracticeService;

    @PostMapping
    private CurdPractice addItem(@RequestBody CurdPractice curdPractice){
        return curdPracticeService.addItem(curdPractice);
    }

    @GetMapping
    private List<CurdPractice> getAllItems(){
        return curdPracticeService.getAllItems();
    }

    @DeleteMapping("/{id}")
    private void deleteItem(@PathVariable("id") int iId){
        curdPracticeService.deleteItem(iId);
    }

    @DeleteMapping("/id/{id}")
    private void deleteItembId(@PathVariable("id") int iId){
        curdPracticeService.deleteItembId(iId);
    }

    @PutMapping("/{id}")
    private CurdPractice updateItem(@RequestBody CurdPractice curdPractice, @PathVariable("id") int iId){
        return curdPracticeService.updateItem(curdPractice,iId);
    }
}
