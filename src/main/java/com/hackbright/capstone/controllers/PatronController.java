package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<PatronDto> getAllPatrons(){
        return patronService.getAllPatrons();
    }

    @GetMapping("/{patronId}")
    public Optional<PatronDto> gePatronById(@PathVariable Long patronId){
        return patronService.getPatronById(patronId);
    }

    @PostMapping
    public void addPatron(@RequestBody PatronDto patronDto){
        patronService.addPatron(patronDto);
    }

    @DeleteMapping("/{patronId}")
    public void deletePatronById(@PathVariable Long patronId){
        patronService.deletePatronById(patronId);
    }

    @PutMapping
    public void updatePatron(@RequestBody PatronDto patronDto){
        patronService.updatePatronById(patronDto);
    }
}
