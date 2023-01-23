package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto implements Serializable {
    private Long id;

    private String instructor_name;

    private List<Lesson> lessons;

    public InstructorDto(Instructor instructor){
        if (instructor.getId() != null){
            this.id = instructor.getId();
        }
        if (instructor.getInstructor_name() != null){
            this.instructor_name = instructor.getInstructor_name();
        }
        if (instructor.getLessons() != null){
            this.lessons = instructor.getLessons();
        }
    }
}
