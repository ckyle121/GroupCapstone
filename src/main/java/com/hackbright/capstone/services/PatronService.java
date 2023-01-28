package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.PatronDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface PatronService {

    @Transactional
    List<String> addPatron(PatronDto patronDto);

    @Transactional
    void deletePatronById(Long patronId);

    @Transactional
    void updatePatronById(PatronDto patronDto);

    List<PatronDto> getAllPatrons();

}
