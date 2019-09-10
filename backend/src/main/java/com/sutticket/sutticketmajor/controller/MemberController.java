package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Member;
import com.sutticket.sutticketmajor.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class MemberController{
    
    @Autowired
    MemberRepository repository;

    @GetMapping("/members")
    public Collection<Member> getAllMembers(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

}