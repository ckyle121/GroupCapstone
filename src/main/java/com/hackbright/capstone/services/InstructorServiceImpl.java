package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstructorDto;
import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Patron;
import com.hackbright.capstone.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    @Transactional
    public List<String> addInstructor(InstructorDto instructorDto) {
        List<String> response = new ArrayList<>();
        Instructor instructor = new Instructor(instructorDto);
        instructorRepository.saveAndFlush(instructor);
        response.add("http://localhost:8080/templates/home.html");
        return response;
    }

    @Override
    @Transactional
    public void deleteInstructor(Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        instructorOptional.ifPresent(instructor -> instructorRepository.delete(instructor));
    }

    @Override
    @Transactional
    public void updateInstructor(InstructorDto instructorDto) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorDto.getId());
        instructorOptional.ifPresent(instructor -> {
            instructor.setInstructorName(instructorDto.getInstructorName());
            instructor.setLessons(instructorDto.getLessons());
            instructorRepository.saveAndFlush(instructor);
        });
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        List<Instructor> instructorList = instructorRepository.findAll();
        return instructorList.stream().map(instructor ->
                new InstructorDto(instructor)).collect(Collectors.toList());
    }

    @Override
    public Optional<InstructorDto> getInstructorById(Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        if (instructorOptional.isPresent()){
            return Optional.of(new InstructorDto(instructorOptional.get()));
        }
        return Optional.empty();
    }
}
