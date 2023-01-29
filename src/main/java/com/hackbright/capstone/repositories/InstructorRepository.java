package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
