package com.hackbright.capstone.repositories;

import com.hackbright.capstone.dtos.InstructorDto;
import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByInstructorName(String instructorName);
}
