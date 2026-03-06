package com.example.placementtracker.controller;

import com.example.placementtracker.entity.Company;
import com.example.placementtracker.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @GetMapping
    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

}