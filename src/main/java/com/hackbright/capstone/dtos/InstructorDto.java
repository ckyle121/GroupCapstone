package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto implements Serializable {
    private Long id;
    private String instructorame;

    private Set<LessonDto> lessonDtoSet = new HashSet<>();

    public InstructorDto(Instructor instructor){
        if (instructor.getId() != null){
            this.id = instructor.getId();
        }
        if(instructor.getInstructorName() != null){
            this.instructorName = instructor.getInstructorName();
        }
    }
}
