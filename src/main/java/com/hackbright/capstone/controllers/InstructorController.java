package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.InstructorDto;
import com.hackbright.capstone.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public void addInstructor (@RequestBody InstructorDto instructorDto) {
        instructorService.addInstructor(instructorDto);
    }

    @DeleteMapping("/{instructorId}")
    public void deleteInstructor (@PathVariable Long instructorId) {
        instructorService.deleteInstructor(instructorId);
    }

    @GetMapping
    public List<InstructorDto> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PutMapping
    public void updateInstructor(@RequestBody InstructorDto instructorDto){
        instructorService.updateInstructor(instructorDto);
    }

    @GetMapping("/{instructorId}")
    public Optional<InstructorDto> geInstructorById(@PathVariable Long instructorId){
        return instructorService.getInstructorById(instructorId);
    }


 /*   @GetMapping("/test")
    public void test() {
        InstructorDto instructorDto = new InstructorDto(null, "Jacob", null);
        instructorService.addInstructor(instructorDto);
        System.out.println(instructorDto);
    }*/

}
