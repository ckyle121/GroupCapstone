package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Lesson;
import com.hackbright.capstone.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByInstructorEquals(Instructor instructor);
    List<Lesson> findAllByPatronEquals(Patron patron);
}