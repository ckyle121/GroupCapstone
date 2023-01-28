package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.InstructorDto;
import com.hackbright.capstone.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping("/addInstructor")
    public void addInstructor (InstructorDto instructorDto) {
        instructorService.addInstructor(instructorDto);
    }

    @DeleteMapping("/deleteInstructor")
    public void deleteInstructor (Long instructorId) {
        instructorService.deleteInstructor(instructorId);
    }

    @GetMapping("/getAllInstructors")
    public void getAllInstructors() {
        System.out.println(instructorService.getAllInstructors());
    }

    @GetMapping("/test")
    public void test() {
        InstructorDto instructorDto = new InstructorDto(null, "Jacob", null);
        instructorService.addInstructor(instructorDto);
        System.out.println(instructorDto);
    }

}
