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
public class InstructorDto {
    private Long id;

    private String instructorName;

    private List<Lesson> lessons;

    public InstructorDto(Instructor instructor){
        if (instructor.getId() != null){
            this.id = instructor.getId();
        }
        if (instructor.getInstructorName() != null){
            this.instructorName = instructor.getInstructorName();
        }
        if (instructor.getLessons() != null){
            this.lessons = instructor.getLessons();
        }
    }
}
