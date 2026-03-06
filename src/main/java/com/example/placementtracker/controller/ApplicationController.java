package com.example.placementtracker.controller;

import com.example.placementtracker.entity.Application;
import com.example.placementtracker.repository.ApplicationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;

    public ApplicationController(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    @PostMapping
    public Application apply(@RequestBody Application application){
        return applicationRepository.save(application);
    }

    @GetMapping
    public List<Application> getAll(){
        return applicationRepository.findAll();
    }

    @GetMapping("/student/{studentId}")
    public List<Application> getApplicationsByStudent(@PathVariable Long studentId){
        return applicationRepository.findByStudentId(studentId);
    }
}