package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstructorDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface InstructorService {
    @Transactional
    List<String> addInstructor(InstructorDto instructorDto);

    @Transactional
    void deleteInstructor(Long instructorId);

    @Transactional
    void updateInstructor(InstructorDto instructorDto);

    List<InstructorDto> getAllInstructors();

    Optional<InstructorDto> getInstructorById(Long instructorId);
}
