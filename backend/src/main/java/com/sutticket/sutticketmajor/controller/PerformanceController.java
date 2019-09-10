package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Performance;
import com.sutticket.sutticketmajor.repository.PerformanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class PerformanceController{

    @Autowired
    PerformanceRepository repository;
    
    @GetMapping("/performances")
    public Collection<Performance> getAllPerformances(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

}