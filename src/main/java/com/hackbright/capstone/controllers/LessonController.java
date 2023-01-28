package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.LessonDto;
import com.hackbright.capstone.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/lesson/{instructorId}")
    public List<LessonDto> getLessonsByInstructor(@PathVariable Long instructorId){
        return lessonService.getAllLessonsByInstructorId(instructorId);
    }

    @PostMapping("/instructor/{instructorId}")
    public void addLesson(@RequestBody LessonDto lessonDto, @PathVariable Long instructorId){
        lessonService.addLesson(lessonDto, instructorId);
    }

    @DeleteMapping("/{lessonId}")
    public void deleteLessonById(@PathVariable Long lessonId){
        lessonService.deleteLessonById(lessonId);
    }

    @PutMapping("/")
    public void updateLesson(@RequestBody LessonDto lessonDto){
        lessonService.updateLessonById(lessonDto);
    }

    @GetMapping("/{lessonId}")
    public Optional<LessonDto> getLessonById(@PathVariable Long lessonId){
        return lessonService.getLessonById(lessonId);
    }
}