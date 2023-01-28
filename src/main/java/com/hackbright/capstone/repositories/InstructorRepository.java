package com.hackbright.capstone.repositories;

import com.hackbright.capstone.dtos.InstructorDto;
import com.hackbright.capstone.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

//    List<InstructorDto> getAllInstructors();

}
