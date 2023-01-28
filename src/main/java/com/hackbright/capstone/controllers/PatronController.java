package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping("")
    public List<PatronDto> getAllPatrons(){
        return patronService.getAllPatrons();
    }

}
