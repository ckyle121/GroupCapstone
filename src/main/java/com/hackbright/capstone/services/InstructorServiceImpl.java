package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstructorDto;
import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Transactional
    public void addInstructor(InstructorDto instructorDto) {
        Instructor instructor = new Instructor(instructorDto);
        instructorRepository.saveAndFlush(instructor);
    }

    @Transactional
    public void deleteInstructor(Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        instructorOptional.ifPresent(instructor -> instructorRepository.delete(instructor));
    }

    public List<InstructorDto> getAllInstructors() {
        List<Instructor> instructorList = instructorRepository.findAll();
        return instructorList.stream().map(instructor ->
                new InstructorDto(instructor)).collect(Collectors.toList());
    }
}
