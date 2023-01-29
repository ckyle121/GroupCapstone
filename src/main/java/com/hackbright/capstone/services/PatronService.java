package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.LessonDto;
import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.entities.Patron;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public interface PatronService {

    @Transactional
    List<String> addPatron(PatronDto patronDto);

    @Transactional
    void deletePatronById(Long patronId);

    @Transactional
    void updatePatronById(PatronDto patronDto);

    List<PatronDto> getAllPatrons();

    Optional<PatronDto> getPatronById(Long patronId);

}
