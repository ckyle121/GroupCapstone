package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstructorDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface InstructorService {

    @Transactional
    void addInstructor(InstructorDto instructorDto);
    @Transactional
    void deleteInstructor(Long instructorId);
    List<InstructorDto> getAllInstructors();

}
