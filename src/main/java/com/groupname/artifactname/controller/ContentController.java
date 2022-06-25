package com.groupname.artifactname.controller;

import com.groupname.artifactname.entity.Answer;
import com.groupname.artifactname.entity.Content;
import com.groupname.artifactname.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @CrossOrigin
    @PostMapping
    private Content addCont(@RequestBody Content content){
        return contentService.addCont(content);
    }

    @GetMapping
    private List<Content> getAllCont(){
       return contentService.getAllCont();
    }

    @PutMapping("/{aId}/{cId}")
    private void addAnstoCont(@PathVariable("aId") int aId, @PathVariable("cId") int cId){
        contentService.addAnsToCont(aId,cId);
    }

    @GetMapping("/answer/{id}")
    private List<Answer> getAnsOfCont(@PathVariable("id") int cId){
        return contentService.getAnsOfCont(cId);
    }

    @PutMapping("/{id}")
    private Content updateCont(@RequestBody Content content, @PathVariable("id") int cId){
        return contentService.updateCont(content, cId);
    }

    @DeleteMapping("/{id}")
    private void deleteCont(@PathVariable("id") int cId){
        contentService.deleteCont(cId);
    }
}
