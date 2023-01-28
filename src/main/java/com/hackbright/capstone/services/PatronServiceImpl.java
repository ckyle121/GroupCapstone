package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.entities.Patron;
import com.hackbright.capstone.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class PatronServiceImpl implements PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Override
    @Transactional
    public List<String> addPatron(PatronDto patronDto) {
        List<String> response = new ArrayList<>();
        Patron patron = new Patron(patronDto);
        patronRepository.saveAndFlush(patron);
        //this URI will change depending on how we want to display the Patrons.
        response.add("http://localhost:8080/templates/home.html");
        return response;
    }

    @Override
    public void deletePatronById(Long patronId) {
        Optional<Patron> patientOptional = patronRepository.findById(patronId);
        patientOptional.ifPresent(patron -> patronRepository.delete(patron));
    }

    @Override
    public void updatePatronById(PatronDto patronDto) {
        Optional<Patron> patientOptional = patronRepository.findById(patronDto.getId());
        patientOptional.ifPresent(patron -> {
            patron.setPatronName(patronDto.getPatronName());
            patron.setLessons(patronDto.getLessons());
            //patron.setOrders(patronDto.getOrders());
            patronRepository.saveAndFlush(patron);
        });
    }

    @Override
    public List<PatronDto> getAllPatrons() {
        List<Patron> patrons = this.patronRepository.findAll();
        return patrons.stream().map(entity -> {
            return new PatronDto(entity);
        }).collect(Collectors.toList());
    }
}
