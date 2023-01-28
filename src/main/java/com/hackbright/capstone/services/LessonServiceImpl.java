package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.LessonDto;
import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Lesson;
import com.hackbright.capstone.entities.Patron;
import com.hackbright.capstone.repositories.InstrumentRepository;
import com.hackbright.capstone.repositories.LessonRepository;
import com.hackbright.capstone.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private PatronRepository patronRepository;
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Override
    public List<LessonDto> getAllLessonsByInstructorId(Long instructorId){
        Optional<Instructor> doctorOptional = instructorRepository.findById(instructorId);
        if (doctorOptional.isPresent()){
            List<Lesson> lessonList = lessonRepository.findAllByInstructorEquals(doctorOptional.get());
            return lessonList.stream().map(lesson -> new LessonDto(lesson)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<LessonDto> getAllLessonsByPatronId(Long patronId){
        Optional<Patron> patronOptional = patronRepository.findById(patronId);
        if (patronOptional.isPresent()){
            List<Lesson> lessonList = lessonRepository.findAllByPatronEquals(patronOptional.get());
            return lessonList.stream().map(lesson -> new LessonDto(lesson)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addLessonByInstructorId(LessonDto lessonDto, Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        Lesson lesson = new Lesson(lessonDto);
        instructorOptional.ifPresent(lesson::setInstructor);
        lessonRepository.saveAndFlush(lesson);
    }

    @Override
    @Transactional
    public List<String> addLesson(LessonDto lessonDto){
        List<String> response = new ArrayList<>();
        Lesson lesson = new Lesson(lessonDto);
        lessonRepository.saveAndFlush(lesson);
        //this will change
        response.add("http://localhost:8080/templates/lesson.html");
        return response;
    }


    @Override
    @Transactional
    public void addLessonByPatronId(LessonDto lessonDto, Long patronId) {
        Optional<Patron> patronOptional = patronRepository.findById(patronId);
        Lesson lesson = new Lesson(lessonDto);
        patronOptional.ifPresent(lesson::setPatron);
        lessonRepository.saveAndFlush(lesson);
    }

    @Override
    @Transactional
    public void deleteLessonById(Long lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        lessonOptional.ifPresent(lesson -> lessonRepository.delete(lesson));
    }

    @Override
    @Transactional
    public void updateLessonById(LessonDto lessonDto) {
        Optional<Lesson> patientOptional = lessonRepository.findById(lessonDto.getId());
        patientOptional.ifPresent(lesson -> {
            lesson.setLesson_time(lessonDto.getLesson_time());
            lesson.setPatron(lessonDto.getPatron());
            lesson.setInstrument(lessonDto.getInstrument());
            lesson.setInstructor(lessonDto.getInstructor());
            lessonRepository.saveAndFlush(lesson);
        });
    }

    @Override
    public Optional<LessonDto> getLessonById(Long lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (lessonOptional.isPresent()){
            return Optional.of(new LessonDto(lessonOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<LessonDto> getAllLessons() {
        List<Lesson> lessons = this.lessonRepository.findAll();
        return lessons.stream().map(entity -> {
            return new LessonDto(entity);
        }).collect(Collectors.toList());
    }

}
