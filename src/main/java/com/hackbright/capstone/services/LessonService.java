package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.LessonDto;
import com.hackbright.capstone.dtos.PatronDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface LessonService {

    @Transactional
    List<String> addLesson(LessonDto lessonDto, Long patronId, Long instructorId);

    List<LessonDto> getAllLessonsByInstructorId(Long instructorId);

    List<LessonDto> getAllLessonsByPatronId(Long patronId);

/*    @Transactional
    void addLessonByInstructorId(LessonDto lessonDto, Long instructorId);

    @Transactional
    void addLessonByPatronId(LessonDto lessonDto, Long patronId);*/

    @Transactional
    void deleteLessonById(Long lessonId);

    @Transactional
    void updateLessonById(LessonDto lessonDto);

    List<LessonDto> getAllLessons();

    Optional<LessonDto> getLessonById(Long lessonId);
}
