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

    @GetMapping("/{instructorId}")
    public List<LessonDto> getLessonsByInstructor(@PathVariable Long instructorId){
        return lessonService.getAllLessonsByInstructorId(instructorId);
    }

    @GetMapping("/{patronId}")
    public List<LessonDto> getLessonsByPatron(@PathVariable Long patronId){
        return lessonService.getAllLessonsByPatronId(patronId);
    }

    @GetMapping("/")
    public List<LessonDto> getAllLessons(){
        return lessonService.getAllLessons();
    }

    @PostMapping("/")
    public void addLesson(@RequestBody LessonDto lessonDto){
        lessonService.addLesson(lessonDto);
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